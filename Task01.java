import java.util.*;

public class Task01 {
    static String buildWithPlus(String[] fields) {
        String ticket = "";
        for (String field : fields) ticket += field;
        return ticket;
    }
    static String buildWithBuilder(String[] fields) {
        StringBuilder sb = new StringBuilder();
        for (String field : fields) sb.append(field);
        return sb.toString();
    }
    static String buildWithBuffer(String[] fields) {
        StringBuffer sb = new StringBuffer();
        for (String field : fields) sb.append(field);
        return sb.toString();
    }
    static long benchmark(java.util.function.Supplier<String> task, int repetitions) {
        // Warm-up
        for (int i=0; i<Math.min(100, repetitions); i++) task.get();
        long start = System.nanoTime();
        for (int i=0; i<repetitions; i++) task.get();
        return (System.nanoTime()-start)/repetitions;
    }
    static void runWorkload(int fieldCount, int tickets) {
        String[] fields = new String[fieldCount];
        for (int i=0; i<fieldCount; i++) fields[i] = "FIELD" + i + "|";
        System.out.println("\\nWorkload: fields/ticket=" + fieldCount + ", tickets=" + tickets);
        System.out.println("String + avg ns/ticket: " +
            benchmark(() -> buildWithPlus(fields), tickets));
        System.out.println("StringBuilder avg ns/ticket: " +
            benchmark(() -> buildWithBuilder(fields), tickets));
        System.out.println("StringBuffer avg ns/ticket: " +
            benchmark(() -> buildWithBuffer(fields), tickets));
        System.out.println("Ticket sample: " + buildWithBuilder(fields));
    }
    public static void main(String[] args) {
        runWorkload(6, 1000);       // short ticket
        runWorkload(50, 10000);     // high-load workload
        runWorkload(200, 2000);     // additional workload
    }
}
