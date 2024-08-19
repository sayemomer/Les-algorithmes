package Array;

import java.util.HashMap;
import java.util.Scanner;

public class minimum_window_substring {

    public static String minWindow(String s, String t) {

        HashMap<Character, Integer> curr_window = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();

        // Fill in the count map with the characters of t
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        // Initialize `have` and `need`
        int have = 0;
        int need = count.size();  // Number of unique characters in t that need to be matched

        // Variables to keep track of the minimum window
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        String result = "";

        // Slide the window
        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            // Update the curr_window map if the character is in t
            if (count.containsKey(key)) {
                curr_window.put(key, curr_window.getOrDefault(key, 0) + 1);

                // If the character's count in curr_window matches the count in count
                if (curr_window.get(key).intValue() == count.get(key).intValue()) {
                    have++;
                }
            }

            // Try to shrink the window
            while (have == need) {
                // Update result if this window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                    result = s.substring(left, right + 1);
                }

                // Move the left pointer to shrink the window
                char curr_key = s.charAt(left);
                if (count.containsKey(curr_key)) {
                    curr_window.put(curr_key, curr_window.get(curr_key) - 1);

                    // If the character count falls below the required count, reduce `have`
                    if (curr_window.get(curr_key) < count.get(curr_key)) {
                        have--;
                    }
                }
                left++;
            }
        }

        // Return the result
        return minLength == Integer.MAX_VALUE ? "" : result;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            String t = sc.nextLine();

            System.out.println(minWindow(s,t));

        }

    }
}
