package Dianami_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class longest_increasing_subsequence {

    public static int lengthOfLIS(int[] nums) {

        //[10,9,2,5,3,7,101,18]

        //first we need to make the associative hashmap of the array

        int[] LIS = new int[nums.length];

        Arrays.fill(LIS,1);

        for (int i = nums.length -1; i >=0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i] ,1 + LIS[j]);
                }

            }
        }

        return Arrays.stream(LIS).max().orElseThrow();

    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(lengthOfLIS(nums));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
