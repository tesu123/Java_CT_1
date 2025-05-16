import java.util.*;

class Planet {
    String name;
    double mass; // in kg
    double radius; // in meters

    public Planet(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public double calculateWeight(double massOnEarth) {
        final double G = 6.674e-11; // gravitational constant
        return massOnEarth * (G * mass) / (radius * radius);
    }
}

public class PlanetWeightCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Planet data
        Planet[] planets = {
                new Planet("MERCURY", 3.303e23, 2.4397e6),
                new Planet("VENUS", 4.869e24, 6.0518e6),
                new Planet("EARTH", 5.976e24, 6.37814e6),
                new Planet("MARS", 6.421e23, 3.3972e6),
                new Planet("JUPITER", 1.9e27, 7.1492e7),
                new Planet("SATURN", 5.688e26, 6.0268e7),
                new Planet("URANUS", 8.686e25, 2.5559e7),
                new Planet("NEPTUNE", 1.024e26, 2.4746e7)
        };

        // Input
        System.out.print("Enter your mass on Earth (in kg): ");
        double massOnEarth = scanner.nextDouble();

        System.out.print("Enter planet name to calculate weight: ");
        String inputPlanet = scanner.next().toUpperCase();

        boolean found = false;
        for (Planet planet : planets) {
            if (planet.name.equals(inputPlanet)) {
                double weight = planet.calculateWeight(massOnEarth);
                System.out.printf("Your weight on %s is %.2f N\n", planet.name, weight);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Planet not found.");
        }

        scanner.close();
    }
}

/*
 * import java.util.Scanner;
 * 
 * enum Planet {
 * MERCURY(3.303e23, 2.4397e6),
 * VENUS(4.869e24, 6.0518e6),
 * EARTH(5.976e24, 6.37814e6),
 * MARS(6.421e23, 3.3972e6),
 * JUPITER(1.9e27, 7.1492e7),
 * SATURN(5.688e26, 6.0268e7),
 * URANUS(8.686e25, 2.5559e7),
 * NEPTUNE(1.024e26, 2.4746e7);
 * 
 * private final double mass; // in kilograms
 * private final double radius; // in meters
 * private static final double G = 6.674e-11; // gravitational constant
 * 
 * // Constructor
 * Planet(double mass, double radius) {
 * this.mass = mass;
 * this.radius = radius;
 * }
 * 
 * // Method to calculate surface gravity
 * public double surfaceGravity() {
 * return (G * mass) / (radius * radius);
 * }
 * 
 * // Method to calculate weight on this planet
 * public double weightOnPlanet(double massOnEarth) {
 * return massOnEarth * surfaceGravity();
 * }
 * }
 * 
 * public class PlanetWeightCalculatorEnum {
 * public static void main(String[] args) {
 * Scanner scanner = new Scanner(System.in);
 * 
 * // Input mass
 * System.out.print("Enter your mass on Earth (in kg): ");
 * double massOnEarth = scanner.nextDouble();
 * 
 * // Input planet name
 * System.out.print("Enter planet name: ");
 * String planetName = scanner.next().toUpperCase();
 * 
 * try {
 * Planet selectedPlanet = Planet.valueOf(planetName);
 * double weight = selectedPlanet.weightOnPlanet(massOnEarth);
 * System.out.printf("Your weight on %s is %.2f N\n", selectedPlanet.name(),
 * weight);
 * } catch (IllegalArgumentException e) {
 * System.out.println("Invalid planet name. Please try again.");
 * }
 * 
 * scanner.close();
 * }
 * }
 * 
 */