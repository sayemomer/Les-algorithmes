package Dianami_programming;

import java.util.Scanner;

public class palindromic_substring {

    public static int countSubstrings(String s) {
        int number_of_substring =0;

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int right =i;

            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                //odd

                left--;
                right++;
                number_of_substring++;

            }

            left = i;
            right =i+1;

            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){

                //odd

                left--;
                right++;
                number_of_substring++;

            }

        }


        return number_of_substring;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            System.out.println(countSubstrings(s));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
