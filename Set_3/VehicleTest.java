class Vehicle {
    void changeGear() {
        System.out.println("Gear changed");
    }

    void applyBrakes() {
        System.out.println("Brakes applied");
    }
}

class Bicycle extends Vehicle {
    void ringBell() {
        System.out.println("Bicycle bell rung");
    }
}

class Car extends Vehicle {
    void honk() {
        System.out.println("Car horn honked");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle();
        bike.changeGear();
        bike.ringBell();
        Car car = new Car();
        car.applyBrakes();
        car.honk();
    }
}