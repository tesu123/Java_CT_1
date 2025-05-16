import java.io.File;
import java.util.Scanner;

public class DirectoryChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String name = sc.nextLine();

        File file = new File(name);

        if (file.isDirectory()) {
            String[] files = file.list();
            System.out.println("Files in directory:");
            if (files != null) {
                for (String f : files) {
                    System.out.println(f);
                    sc.close();
                }
            }
        } else {
            System.out.println("Not a directory");
        }
    }
}
