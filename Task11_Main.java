import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

abstract class Vehicle {
    private final String regNo;
    Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo.toUpperCase();
    }
    String getRegNo() { return regNo; }
    abstract double rate();
}
class TwoWheeler extends Vehicle {
    TwoWheeler(String r) { super(r); }
    double rate() { return 10.0; }
}
class Car extends Vehicle {
    Car(String r) { super(r); }
    double rate() { return 30.0; }
}
class ElectricCar extends Car {
    ElectricCar(String r) { super(r); }
}
class ParkingTicket {
    private static long counter = 1000;
    final long number = ++counter;
    final Vehicle vehicle;
    final LocalDateTime entry;
    final int floor, slot;
    ParkingTicket(Vehicle v, LocalDateTime e, int f, int s) {
        vehicle=v; entry=e; floor=f; slot=s;
    }
    double fee(LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        if (minutes < 0) throw new IllegalArgumentException("Exit before entry");
        int hours = (int)((minutes + 59) / 60);
        return hours * vehicle.rate();
    }
}
class ParkingFacility {
    private final String[][] slots;
    private final Map<String, ParkingTicket> active = new HashMap<>();
    ParkingFacility(int[] capacities) {
        slots = new String[capacities.length][];
        for (int i=0;i<capacities.length;i++) slots[i]=new String[capacities[i]];
    }
    ParkingTicket enter(Vehicle v, LocalDateTime time) {
        if (active.containsKey(v.getRegNo())) throw new IllegalArgumentException("Duplicate active vehicle");
        for(int f=0;f<slots.length;f++) for(int s=0;s<slots[f].length;s++)
            if(slots[f][s]==null) {
                slots[f][s]=v.getRegNo();
                ParkingTicket t=new ParkingTicket(v,time,f,s);
                active.put(v.getRegNo(),t);
                return t;
            }
        throw new IllegalStateException("No free slot");
    }
    double exit(String reg, LocalDateTime time) {
        ParkingTicket t=active.get(reg.toUpperCase());
        if(t==null) throw new IllegalArgumentException("No active ticket");
        double fee=t.fee(time);
        active.remove(reg.toUpperCase());
        slots[t.floor][t.slot]=null;
        return fee;
    }
    int activeCount() { return active.size(); }
}
public class Task11_Main {
    public static void main(String[] args) {
        ParkingFacility p=new ParkingFacility(new int[]{2,1});
        LocalDateTime in=LocalDateTime.of(2026,10,26,10,0);
        LocalDateTime out=LocalDateTime.of(2026,10,26,11,10);
        p.enter(new Car("TN01AB1111"),in);
        p.enter(new TwoWheeler("TN02CD2222"),in);
        System.out.println("Car fee: Rs "+p.exit("TN01AB1111",out));
        System.out.println("Bike fee: Rs "+p.exit("TN02CD2222",out));
        System.out.println("Active vehicles: "+p.activeCount());
    }
}
