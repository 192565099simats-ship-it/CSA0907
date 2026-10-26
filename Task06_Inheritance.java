abstract class Vehicle {
    protected final String registrationNumber;
    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        System.out.println("Vehicle constructor");
    }
}
class Car extends Vehicle {
    Car(String registrationNumber) {
        super(registrationNumber);
        System.out.println("Car constructor");
    }
}
class ElectricCar extends Car {
    ElectricCar(String registrationNumber) {
        super(registrationNumber);
        System.out.println("ElectricCar constructor");
    }
}
public class Task06_Inheritance {
    public static void main(String[] args) {
        new ElectricCar("TN03C3");
    }
}
