package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class house_robber_II {

    public static int rob_I(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max((rob1 + nums[i]) ,rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;
    }

    public  static int rob(int[] nums) {

        // 1 , 2 , 3

        // 1 , 2 ,3 , 1

        // 1+3 = 4

        // 2 , 3 , 1

        // => 0,0,2,3,1 => 0 , 0+ 2
        // 0, 2 , 3, 1  => 2 , 2 + 1 +> 2 , 3

        // 0 , 0, 1,2,3 => 0 , 0 + 1 => 1
        // 1 ,2 ,3 => 1 , 1 +3 => 4

        return Math.max(rob_I(Arrays.copyOfRange(nums,0,nums.length-1)), rob_I(Arrays.copyOfRange(nums,1 ,nums.length )));

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(rob(nums));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
