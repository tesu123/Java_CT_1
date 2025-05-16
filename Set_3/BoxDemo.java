// Superclass: Box
class Box {
    double length;
    double breadth;
    double height;

    public Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public void display() {
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Height: " + height);
    }
}

// Subclass: ColorBox extends Box
class ColorBox extends Box {
    String color;

    public ColorBox(double length, double breadth, double height, String color) {
        super(length, breadth, height);
        this.color = color;
    }

    // Overriding display to also show color
    @Override
    public void display() {
        super.display(); // call Box display
        System.out.println("Color: " + color);
    }
}

// Main class
public class BoxDemo {
    public static void main(String[] args) {
        // Box reference pointing to ColorBox object
        Box myBox = new ColorBox(10, 5, 4, "Red");

        // Using reference to call the display method
        myBox.display();

        // Note: We cannot access 'color' directly using Box reference
        // ((ColorBox) myBox).color would work if needed
    }
}
