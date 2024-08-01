package Dianami_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class coin_change {

    public static int coinChange_dp(int[] coins, int amount) {

        //here we need a dp for each amount
        // like 0 to amount

        // 2 5
        //3

        //
        // 1-2 =0 Min( inf ,1 + dp[0]) => inf
        // 2-2 = 0 Min( inf , 1 + dp[0] ) => 1
        // 3 - 2 = 1  Min( inf, 1 + dp[1] ) =>  inf
        //

        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] =0;

        for (int i = 1; i < dp.length; i++) {

            for (int coin : coins){

                //for each coin we will compatibility

                if(i-coin >=0 &&dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1 + dp[i-coin]);
                }

            }
        }

        return dp[amount] == Integer.MAX_VALUE  ? -1 : dp[amount];

    }

    public static int coinChange(int[] coins, int amount) {

        //first we need a base case , the amount is gonna get less for each recursive call
        // so its gonna 0 or less than that in the base
        // when its 0 we are gonna return 1 coz its possible case to use that coin
        // Base cases
        if (amount == 0) return 0; // No coins needed to make 0 amount
        if (amount < 0) return -1; // Not possible to make negative amount

        int minCoins = Integer.MAX_VALUE;

        // Explore all coin options
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin);

            if (result >= 0 && result < minCoins) {
                minCoins = result + 1;
            }
        }

        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] coins = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int amount = Integer.parseInt(sc.nextLine());

            System.out.println(coinChange_dp(coins,amount));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
