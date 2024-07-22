package Dianami_programming;

import java.util.Scanner;

public class palindromic_substrings {

    public static int countSubstrings(String s) {

        int result = 0 ;

        String[] s_arr = s.split("");

        for (int i = 0; i < s_arr.length; i++) {

            int left = i;
            int right = i;

            //odd palindrome

            while (left>=0 && right< s_arr.length && s_arr[left].equals(s_arr[right])){
                result++;
                left--;
                right++;
            }

            left = i;
            right = i+1;

            //even palindrome

            while (left>=0 && right< s_arr.length && s_arr[left].equals(s_arr[right])){
                result++;
                left--;
                right++;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();

            System.out.println(countSubstrings(s));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
