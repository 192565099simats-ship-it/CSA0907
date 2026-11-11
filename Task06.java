import java.util.*;

public class Task06 {
    static class Patient {
        final String name; final int severity; final long arrival;
        Patient(String name,int severity,long arrival){
            this.name=name;this.severity=severity;this.arrival=arrival;
        }
        @Override public String toString(){return name+"(S"+severity+")";}
    }
    static class Triage {
        private long counter=0;
        private final PriorityQueue<Patient> queue = new PriorityQueue<>(
            Comparator.comparingInt((Patient p)->p.severity)
                      .thenComparingLong(p->p.arrival));
        void admit(String name,int severity){
            if(severity<1 || severity>5) throw new IllegalArgumentException("Severity must be 1..5");
            queue.add(new Patient(name,severity,counter++));
        }
        Patient next(){return queue.poll();}
        void displayTreatmentOrder(){
            PriorityQueue<Patient> copy=new PriorityQueue<>(queue);
            while(!copy.isEmpty()) System.out.print(copy.poll()+" ");
            System.out.println();
        }
    }
    public static void main(String[] args){
        Triage er=new Triage();
        er.admit("Ravi",3); er.admit("Meena",1); er.admit("John",3);
        er.admit("Asha",5); er.admit("Kumar",1); er.admit("Lata",2);
        er.displayTreatmentOrder();
    }
}
