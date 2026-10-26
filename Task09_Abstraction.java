interface Chargeable {
    double chargingFee(int kWh);
}
abstract class Vehicle {
    private final String registrationNumber;
    protected Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double ratePerHour();
}
class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String registrationNumber) { super(registrationNumber); }
    @Override public double ratePerHour() { return 30.0; }
    @Override public double chargingFee(int kWh) { return kWh * 12.0; }
}
public class Task09_Abstraction {
    public static void main(String[] args) {
        Chargeable c = new ElectricCar("TN03C3");
        System.out.println(c.chargingFee(5));
    }
}
