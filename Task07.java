import java.util.*;

/*
 Q7 redesign: retain the original unsorted-list design, then use a maintained
 TreeMap index for code-ordered reporting and HashMap for direct lookup.
 This sample focuses on the Q4 inventory bottleneck and avoids sorting the
 full inventory every time a code-order report is requested.
*/
public class Task07 {
    static class Medicine {
        final String code; final String name; final int stock;
        Medicine(String c,String n,int s){code=c;name=n;stock=s;}
    }
    static class OriginalInventory {
        final List<Medicine> items=new ArrayList<>();
        void add(Medicine m){items.add(m);}
        Medicine find(String code){
            for(Medicine m:items) if(m.code.equals(code)) return m;
            return null;
        }
        List<Medicine> codeReport(){
            List<Medicine> copy=new ArrayList<>(items);
            copy.sort(Comparator.comparing(m->m.code));
            return copy;
        }
    }
    static class RedesignedInventory {
        final Map<String,Medicine> byCode=new HashMap<>();
        final NavigableMap<String,Medicine> ordered=new TreeMap<>();
        void add(Medicine m){byCode.put(m.code,m);ordered.put(m.code,m);}
        Medicine find(String code){return byCode.get(code);}
        List<Medicine> codeReport(){return new ArrayList<>(ordered.values());}
    }
    public static void main(String[] args){
        int n=20000;
        OriginalInventory old=new OriginalInventory();
        RedesignedInventory redesigned=new RedesignedInventory();
        for(int i=n-1;i>=0;i--){
            Medicine m=new Medicine(String.format("MED%06d",i),"Medicine "+i,100+i);
            old.add(m); redesigned.add(m);
        }
        String target="MED010000";
        long a=System.nanoTime(); Medicine x=old.find(target); long oldLookup=System.nanoTime()-a;
        a=System.nanoTime(); Medicine y=redesigned.find(target); long newLookup=System.nanoTime()-a;
        a=System.nanoTime(); List<Medicine> oldReport=old.codeReport(); long oldReportTime=System.nanoTime()-a;
        a=System.nanoTime(); List<Medicine> newReport=redesigned.codeReport(); long newReportTime=System.nanoTime()-a;
        System.out.println("Original lookup found: "+(x!=null)+", ns="+oldLookup);
        System.out.println("Redesigned lookup found: "+(y!=null)+", ns="+newLookup);
        System.out.println("Original report ns: "+oldReportTime+", first="+oldReport.get(0).code);
        System.out.println("Redesigned report ns: "+newReportTime+", first="+newReport.get(0).code);
        System.out.println("Note: run repeatedly; one timing is illustrative, not conclusive.");
    }
}
