package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class house_robber {

    public static int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max((rob1 + nums[i]) ,rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;
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
