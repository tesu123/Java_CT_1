import java.io.File;

public class ListOnlyFiles {
    public static void main(String[] args) {
        // Replace with your target directory path
        File directory = new File("Path_to_directory");

        if (directory.exists() && directory.isDirectory()) {
            File[] contents = directory.listFiles();

            System.out.println("\nFiles in the directory:");
            for (File file : contents) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}
