package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longest_non_repeating_char {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength=0;

        int leftPointer = 0;
        Set<Character> charSet = new HashSet<Character>();

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {

            System.out.println(s.charAt(rightPointer));

            while (charSet.contains(s.charAt(rightPointer))){
                charSet.remove(s.charAt(leftPointer));
                leftPointer++;
            }

            maxLength = Math.max(maxLength,( rightPointer - leftPointer ) +1);

            charSet.add(s.charAt(rightPointer));

        }


        return maxLength;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            System.out.println(lengthOfLongestSubstring(s));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
