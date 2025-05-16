import java.util.Scanner;

public class LongestPalindromeFinder {

    // Function to check if a string is a palindrome
    static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    // Function to find longest palindrome substring
    static String findLongestPalindrome(String input) {
        String longest = "";
        int n = input.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = input.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter a string");
            System.out.println("2. Find longest palindrome");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter the string: ");
                    input = scanner.nextLine();
                    break;

                case 2:
                    if (input.isEmpty()) {
                        System.out.println("Please enter a string first.");
                    } else {
                        String result = findLongestPalindrome(input);
                        System.out.println("Longest palindrome: " + result);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
