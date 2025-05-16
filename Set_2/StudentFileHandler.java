import java.io.*;

public class StudentFileHandler {

    // Serializable class
    static class Student implements Serializable {
        private int roll;
        private String name;
        private int score;

        public Student(int roll, String name, int score) {
            this.roll = roll;
            this.name = name;
            this.score = score;
        }

        public void display() {
            System.out.println("Roll: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String filename = "students.dat";

        // Create a few Student objects and write to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new Student(101, "Alice", 89));
            oos.writeObject(new Student(102, "Bob", 76));
            oos.writeObject(new Student(103, "Charlie", 92));
            System.out.println("Student objects written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read and display Student objects from file
        System.out.println("\nReading student objects from file:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                Student s = (Student) ois.readObject();
                s.display();
            }
        } catch (EOFException e) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
