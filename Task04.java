import java.util.*;

public class Task04 {
    static long lookupTime(Map<String,Integer> map, int lookups) {
        long start=System.nanoTime();
        int total=0;
        for(int i=0;i<lookups;i++) total += map.get(String.format("MED%06d", i%map.size()));
        long elapsed=System.nanoTime()-start;
        if(total==Long.MIN_VALUE) System.out.println(total);
        return elapsed;
    }
    public static void main(String[] args) {
        int[] sizes={1000,10000,50000};
        for(int n:sizes) {
            Map<String,Integer> hash=new HashMap<>();
            Map<String,Integer> tree=new TreeMap<>();
            Map<String,Integer> linked=new LinkedHashMap<>();
            for(int i=0;i<n;i++){
                String code=String.format("MED%06d",i);
                hash.put(code,i); tree.put(code,i); linked.put(code,i);
            }
            System.out.println("\\nMedicines="+n);
            System.out.println("HashMap 100000 lookups ns: "+lookupTime(hash,100000));
            System.out.println("TreeMap 100000 lookups ns: "+lookupTime(tree,100000));
            System.out.println("LinkedHashMap 100000 lookups ns: "+lookupTime(linked,100000));
            System.out.println("TreeMap first codes: "+tree.keySet().stream().limit(5).toList());
            System.out.println("LinkedHashMap first codes: "+linked.keySet().stream().limit(5).toList());
        }
    }
}
