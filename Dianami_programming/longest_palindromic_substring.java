package Dianami_programming;

import java.util.Scanner;

public class longest_palindromic_substring {

    public  static String longestPalindrome(String s) {

        // babad

        //bab

        String result_str = "";
        int max_palindrome_len = 0;

        for (int i = 0; i < s.length() + 1; i++) {

            int left =i;
            int right=i;

            //odd substring

            while (left>=0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){

                if(( (right - left) +1) > max_palindrome_len){
                    max_palindrome_len = (right - left) +1;
                    result_str = s.substring(left , right + 1);
                }

                left--;
                right++;

            }

            //even substring

            left = i;
            right = i + 1;

            while (left>=0 && right <= s.length()-1  && s.charAt(left) == s.charAt(right)){

                if(( (right - left) +1) > max_palindrome_len){
                    max_palindrome_len = (right - left) +1;
                    result_str = s.substring(left , right + 1);
                }

                left--;
                right++;

            }


        }

        return result_str;



    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String str = sc.nextLine();

            System.out.println(longestPalindrome(str));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
