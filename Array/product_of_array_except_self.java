package Array;

import java.util.Arrays;
import java.util.Scanner;

public class product_of_array_except_self {



    public static int[] productExceptSelf_pro(int[] nums){

        int[] sum_product = new int[nums.length];

        // firstly, we are gonna calculate the prefix 
        // and store it to the sum_product array , intially the prefix is 1

        int prefix = 1;

        // here we are updating the prefix and the value in product array
        //eg : nums[i]== 1 , prefix =1 , so , sum_product = prefix , prefix = prefix * nums[1] (1 * 1)
        // for nums[i] == 2 , prefix = 1 , so the sum_product = prefix, prefix = ( 2 * 1)

        for (int i = 0; i < nums.length; i++) {
            sum_product[i] = prefix;
            prefix = prefix * nums[i];
        }

        // now we calcualte the postfix and the value in product array
        // now we are gonna calculate the post fix, so initially the postfix is 1
        // so if the array is [1,2, 3, 4] we start from last index, so the postfix will be 
        // iter 1: and the postfix will be updated to 
            // sum_product[0] =  postfix * sum_product[0] ( 24 * 1)
            // postfix = postfix * nums[0] ( 24 * 1 ) = 24
        // iter 2: postfix = postfix * sum_product[2] (6 * 2 )

        int postfix = 1;

        for (int i = nums.length -1 ; i >= 0; i--) {

            sum_product[i] = postfix * sum_product[i];
            postfix = postfix * nums[i];
            
        }

        return sum_product;

    }


    /**
     * This solution hits TLE in leetcode , passes 18 / 24 testcases
     * @param nums
     * @return product array
     */

    public static int[] productExceptSelf(int[] nums) {

        //we need a new array to return the producted list

        int[] sum_product = new int[nums.length];

        //we are gonna make magic list to calculate the product
        // which will include numbers except the first for now
        // eg: [1,2,3,4] -> [2,3,4]

        int[] magic_list = new int[nums.length -1];
        int magic_index = 0;
        for (int i = 0; i < magic_list.length; i++) {
            magic_list[i] = nums[i+1];
        }

        // now, we are gonna loop through the orginal number and calculate the product
        // of sum index through the magic list

        for (int j = 0; j < sum_product.length; j++) {

            int product = Arrays.stream(magic_list).reduce(1, (a,b)-> a * b );

            sum_product[j] = product;

            // here we are changing the magic list content
            // ie after one iter it gonna be [2,3,4] -> [1,3,4]

            if( j < magic_list.length){
                magic_list[magic_index] = nums[j];
                magic_index++;
            }
                
        }



        return sum_product;
    }

    
    public static void main(String[] args) {


        try(Scanner sc = new Scanner(System.in)) {

            String nums = sc.nextLine();

            String[] nums_a = nums.split(" ");
            int[] numbers = new int[nums_a.length];

            for (int i = 0; i < nums_a.length; i++) {

                numbers[i] = Integer.parseInt(nums_a[i]);
                
            }

            int[] arr = productExceptSelf_pro(numbers);

            for (int a : arr) {
                System.out.println(a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
