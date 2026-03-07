package Array;

import java.util.Arrays;
import java.util.Scanner;

public class buy_sell_stock {

    public static int maxProfit(int[] prices) {

        int max_profit = 0;

        int start =0;
        int end=0;

        while (start < prices.length && end < prices.length){

            if(prices[start] < prices[end]){
                max_profit = Math.max(max_profit,prices[end] - prices[start]);
            }else {
                start = end;
            }
            end++;

        }

        return max_profit;

    }
        public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(maxProfit(prices));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
