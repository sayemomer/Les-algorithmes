package Array;

import java.util.Scanner;

public class best_time_to_buy_and_sell_stock {

    public static int maxProfit(int[] prices) {

        //d'occord ! lets go ahead with a two pointer 

        int first_pointer = 0;
        int second_pointer = first_pointer + 1;
        int maxProfit =0;

        while (second_pointer < prices.length) {

            // here we check , if the second pointer is greater thant the first pointer 

            int profit=0 ;

            if(prices[second_pointer]>prices[first_pointer]){
                profit = prices[second_pointer] - prices[first_pointer];
                maxProfit = Math.max(maxProfit, profit);

                //if its a profit we move the second pointer , to find the minimum
                //otherwise we move both pointer
                second_pointer++;
            }else{

                first_pointer = second_pointer;
                second_pointer = first_pointer + 1;

            }

            
            
        }

        return maxProfit;
        
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] price_s = sc.nextLine().split(" ");
            int[] prices = new int[price_s.length];
            for (int i = 0; i < price_s.length; i++) {
                prices[i] = Integer.parseInt(price_s[i]);
            }

            System.out.println(maxProfit(prices));

            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
