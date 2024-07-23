package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class longest_common_subsequence {

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1 ][text2.length()+ 1];

        for (int[] row : dp){
            Arrays.fill(row,0);
        }

        for (int i = dp.length - 2; i >=0 ; i--) {

            for (int j = dp[0].length - 2; j >= 0; j--) {

                if(text1.charAt(i) == text2.charAt(j)){
                    //if its same we are gonna sumup the below cell + 1
                    dp[i][j] = 1 + dp[i+1][j + 1];
                }else {
                    dp[i][j] = Math.max(dp[i][j+1] ,dp[i+1][j]);
                }

            }

        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String text1 = sc.nextLine();
            String text2 = sc.nextLine();

            System.out.println(longestCommonSubsequence(text1,text2));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
