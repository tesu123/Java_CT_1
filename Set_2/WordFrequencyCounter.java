import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Sample list of words
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "apple", "grape");

        // HashMap to store word and frequency
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            // If word is already in map, increment its count
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Display word frequencies
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
