// Superclass: Vehicle
abstract class Vehicle {
    protected String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public void showType() {
        System.out.println("\nThis is a " + type);
    }

    abstract void changeGear();

    abstract void applyBrakes();
}

// Subclass: Autorickshaw
class Autorickshaw extends Vehicle {
    public Autorickshaw() {
        super("Autorickshaw");
    }

    @Override
    void changeGear() {
        System.out.println("Autorickshaw changes gear manually.");
    }

    @Override
    void applyBrakes() {
        System.out.println("Autorickshaw applies drum brakes.");
    }

}

// Subclass: EV
class EV extends Vehicle {
    public EV() {
        super("Electric Vehicle");
    }

    @Override
    void changeGear() {
        System.out.println("EV changes gear automatically.");
    }

    @Override
    void applyBrakes() {
        System.out.println("EV applies regenerative brakes.");
    }

}

// Main method
public class VehicleDemo {
    public static void main(String[] args) {
        Autorickshaw auto = new Autorickshaw();

        auto.showType();
        auto.changeGear();
        auto.applyBrakes();

        EV evCar = new EV();
        evCar.showType();
        evCar.changeGear();
        evCar.applyBrakes();
    }
}