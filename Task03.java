import java.util.*;

public class Task03 {
    static class Student {
        final String regNo, name;
        Student(String regNo, String name) { this.regNo=regNo; this.name=name; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student s=(Student)o;
            return Objects.equals(regNo,s.regNo);
        }
        @Override public int hashCode() { return Objects.hash(regNo); }
        @Override public String toString() { return regNo+" "+name; }
    }
    static class BrokenStudent {
        String regNo, name;
        BrokenStudent(String r,String n){regNo=r;name=n;}
        @Override public boolean equals(Object o){
            return o instanceof BrokenStudent &&
                Objects.equals(regNo,((BrokenStudent)o).regNo);
        }
        // Deliberately no hashCode override: demonstrates contract violation.
    }
    public static void main(String[] args) {
        Set<Student> corrected = new HashSet<>();
        corrected.add(new Student("192311001","Arun"));
        corrected.add(new Student("192311002","Divya"));
        corrected.add(new Student("192311001","Arun"));
        System.out.println("Corrected unique students: "+corrected.size());

        Set<BrokenStudent> broken = new HashSet<>();
        broken.add(new BrokenStudent("S101","Asha"));
        broken.add(new BrokenStudent("S102","Bala"));
        broken.add(new BrokenStudent("S101","Asha"));
        System.out.println("Broken set size (may vary with hash distribution): "+broken.size());

        // Third test: mutation of an equality/hash field after insertion.
        Student mutableKey = new Student("S201","Charan");
        Set<Student> stable = new HashSet<>();
        stable.add(mutableKey);
        System.out.println("Contains before change: "+stable.contains(mutableKey));
        // Student fields are final, intentionally preventing this dangerous mutation.
        System.out.println("Hash key fields are final: mutation prevented by design.");
    }
}
