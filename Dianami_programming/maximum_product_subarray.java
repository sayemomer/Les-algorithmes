package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class maximum_product_subarray {

    public static int maxProduct(int[] nums) {

        //2 3 -2 4
        //-2 0 -1
        //-3 -1 -1
        //0 2

        int max_product = nums[0];
        int curr_max = 1;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                curr_max = 1;
                continue;
            }
            curr_max *= nums[i];
            max_product = Math.max(curr_max,max_product);

        }

        return max_product;
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
