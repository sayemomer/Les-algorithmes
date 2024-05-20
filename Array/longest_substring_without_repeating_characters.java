package Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1263307475/
 */

public class longest_substring_without_repeating_characters {


    public static int lengthOfLongestSubstring(String s) {
        
        String[] sen_a = s.split("");
        Set<String> char_container = new HashSet<>();

        //so here we need two pointer as sliding window
        // we need a charset to keep track of the unique character
        // initially we have the leftpointer at first index and the right pointer as the next index

        int left_pointer = 0;

        int max_len =0;

        for(int right_pointer =0 ; right_pointer<s.length(); right_pointer ++){

            while (char_container.contains(sen_a[right_pointer])) {
                char_container.remove(sen_a[left_pointer]);
                left_pointer++;
            }
            char_container.add(sen_a[right_pointer]);
            max_len = Math.max(max_len, right_pointer - left_pointer + 1);
            
        }

        return max_len;
        
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();

            System.out.println(lengthOfLongestSubstring(s));
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
