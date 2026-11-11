import java.util.*;

public class Task02 {
    static volatile long sink;
    static long timeNanos(Runnable action, int repetitions) {
        long start = System.nanoTime();
        for (int i=0; i<repetitions; i++) action.run();
        return System.nanoTime()-start;
    }
    static void test(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();
        for (int i=0; i<n; i++) { array.add(i); linked.add(i); }
        int reps = Math.max(100, 1000000/n);
        System.out.println("\\nN=" + n);
        System.out.println("ArrayList append ns/op: " +
            timeNanos(() -> array.add(-1), reps)/(double)reps);
        System.out.println("LinkedList append ns/op: " +
            timeNanos(() -> linked.add(-1), reps)/(double)reps);
        array.remove(array.size()-1); linked.removeLast();
        System.out.println("ArrayList get-middle ns/op: " +
            timeNanos(() -> sink += array.get(array.size()/2), reps)/(double)reps);
        System.out.println("LinkedList get-middle ns/op: " +
            timeNanos(() -> sink += linked.get(linked.size()/2), reps)/(double)reps);
        System.out.println("ArrayList insert-front ns/op: " +
            timeNanos(() -> { array.add(0,-1); array.remove(0); }, reps)/(double)reps);
        System.out.println("LinkedList insert-front ns/op: " +
            timeNanos(() -> { linked.addFirst(-1); linked.removeFirst(); }, reps)/(double)reps);
        ArrayDeque<Integer> deque = new ArrayDeque<>(n+10);
        for (int i=0; i<n; i++) deque.addLast(i);
        System.out.println("ArrayDeque add/remove ends ns/op: " +
            timeNanos(() -> { deque.addFirst(-1); deque.removeFirst(); }, reps)/(double)reps);
        System.out.println("ArrayList full iteration ns: " +
            timeNanos(() -> { long s=0; for(int x:array) s+=x; sink=s; }, 10)/10.0);
        System.out.println("LinkedList full iteration ns: " +
            timeNanos(() -> { long s=0; for(int x:linked) s+=x; sink=s; }, 10)/10.0);
    }
    public static void main(String[] args) {
        test(1000); test(10000); test(100000);
    }
}
