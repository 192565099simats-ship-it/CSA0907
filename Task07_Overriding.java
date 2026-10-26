abstract class Vehicle {
    private final String registrationNumber;
    Vehicle(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double calculateFee(int minutes);

    @Override public boolean equals(Object other) {
        return other instanceof Vehicle v &&
               registrationNumber.equals(v.registrationNumber);
    }
    @Override public int hashCode() { return registrationNumber.hashCode(); }
    @Override public String toString() { return getClass().getSimpleName() + "[" + registrationNumber + "]"; }
}
class Car extends Vehicle {
    Car(String registrationNumber) { super(registrationNumber); }
    @Override public double calculateFee(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Negative minutes");
        return ((minutes + 59) / 60) * 30.0;
    }
}
public class Task07_Overriding {
    public static void main(String[] args) {
        Vehicle v = new Car("TN02B2");
        System.out.println(v.calculateFee(61));
        System.out.println(v);
    }
}
