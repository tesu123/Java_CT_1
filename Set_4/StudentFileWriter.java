import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private int roll;
    private double marks;

    public Student(String name, int roll, double marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Marks: " + marks;
    }
}

public class StudentFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Roll: ");
            int roll = scanner.nextInt();
            System.out.print("Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            students.add(new Student(name, roll, marks));
        }

        // Write to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
            System.out.println("\nStudent details saved to 'students.dat'");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}