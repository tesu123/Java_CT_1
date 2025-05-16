import java.util.HashMap;

public class StudentScores {
    public static void main(String[] args) {
        HashMap<Integer, Integer> scores = new HashMap<>();

        // Store roll-score pairs
        scores.put(101, 85);
        scores.put(102, 90);
        scores.put(103, 78);

        // Query a score
        int roll = 102;
        if (scores.containsKey(roll)) {
            System.out.println("Score of Roll " + roll + ": " + scores.get(roll));
        } else {
            System.out.println("Roll number not found.");
        }
    }
}
