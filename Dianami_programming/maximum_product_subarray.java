package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class maximum_product_subarray {

    public static int maxProduct(int[] nums) {

        double curr_min = nums[0];
        double curr_max = nums[0];
        double result = curr_max;

        for (int i = 1; i < nums.length; i++) {

            double prev_max = curr_max;

            curr_max = Math.max( Math.max(nums[i],curr_min * nums[i]) ,curr_max * nums[i]);
            curr_min = Math.min( Math.min(nums[i],curr_min * nums[i]) ,prev_max * nums[i]);

            result= Math.max(curr_max,result);

        }

        return (int) result;
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            int nums[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(maxProduct(nums));

        }catch (Exception e){
            System.out.println();
        }
    }
}
