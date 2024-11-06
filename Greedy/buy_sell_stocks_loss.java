package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class buy_sell_stocks_loss {

    public static int get_max_loss(int[] market){
        int max_loss = 0;

        int p=0;

        for (int i = 1; i < market.length; i++) {

            //loss

            int loss_or_profit = (market[p] - market[i] );

            if( loss_or_profit > 0){

                max_loss = Math.max(max_loss,loss_or_profit);
            }else {
                p = i;
            }

        }

        return max_loss;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int[] market = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(get_max_loss(market));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
