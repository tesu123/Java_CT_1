public class DishProgram {

    // Inner Dish class
    static class Dish {
        private String name;
        private String type; // veg, fish, meat
        private int calories;

        // Constructor
        public Dish(String name, String type, int calories) {
            this.name = name;
            this.type = type;
            this.calories = calories;
        }

        // Method to display dish info
        public void displayInfo() {
            System.out.println("Dish Name: " + name);
            System.out.println("Dish Type: " + type);
            System.out.println("Calories: " + calories);
        }
    }

    // Main method
    public static void main(String[] args) {
        Dish d1 = new Dish("Paneer Butter Masala", "veg", 450);
        Dish d2 = new Dish("Grilled Salmon", "fish", 300);

        d1.displayInfo();
        System.out.println();
        d2.displayInfo();
    }
}
