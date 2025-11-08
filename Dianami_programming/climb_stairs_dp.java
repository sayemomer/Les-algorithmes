package Dianami_programming;

import java.util.Scanner;

public class climb_stairs_dp {

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;
        dp[2] =2;

        if(n <= 2){
            return dp[n];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int n = Integer.parseInt(sc.nextLine());
            System.out.println(climbStairs(n));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
