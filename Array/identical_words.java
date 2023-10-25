import java.util.Scanner;

public class identical_words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Number of words
        int M = scanner.nextInt(); // Word length
        scanner.nextLine(); // Consume the newline character

        String minWord = null;
        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            int changes = countAlphabetChanges(word);

            if (changes < minChanges || (changes == minChanges && (minWord == null || word.compareTo(minWord) < 0))) {
                minChanges = changes;
                minWord = word;
            }
        }

        System.out.println(minWord);
        System.out.println(minChanges);

        scanner.close();
    }

    // Function to count the number of alphabet changes in a word
    public static int countAlphabetChanges(String word) {
        int changes = 0;
        String alphabet = "abcde";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != alphabet.charAt(i % 5)) {
                changes++;
            }
        }
        return changes;
    }
}
