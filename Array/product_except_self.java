package Array;

import java.util.Arrays;
import java.util.Scanner;

public class product_except_self {

    public static int[] productExceptSelf(int[] nums) {

        int[] resutNums = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postFix = new int[nums.length];

        // 1 2 3 4

        int pre = 1;
        int post = 1;

        for (int i = 0; i < prefix.length; i++) {

            prefix[i]= nums[i] * pre;
            pre = prefix[i];

        }

        for (int i = postFix.length - 1; i >= 0; i--) {
            postFix[i] = nums[i] * post;
            post = postFix[i];
        }

//        System.out.println(Arrays.toString(postFix));
//        System.out.println(Arrays.toString(prefix));


        //now calcualte the result

        //[1, 2, 6, 24]
        //[24, 24, 12, 4]

        pre = 1;
        post = 1;

        for (int i = 0; i < resutNums.length ; i++) {

            if(i + 1 <postFix.length){
                resutNums[i] = pre * postFix[i+1];
                pre = prefix[i];
            }else {
                resutNums[i] = pre * post;
            }

        }

//        System.out.println(Arrays.toString(resutNums));

        return resutNums;
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(productExceptSelf(nums));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
