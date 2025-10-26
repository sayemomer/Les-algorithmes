package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Long_con_seq {

    public static int longestConsecutive(int[] nums) {

        int result = 0;

        Set<Integer> nums_set = new HashSet<>();

        for (int num : nums){
            nums_set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            //check in backward from this number

            int prevNumber = nums[i] - 1;
            int curr_length = 1;

            if(!nums_set.contains(prevNumber)){
                int nextNumber = nums[i] + 1;

                while (nums_set.contains(nextNumber)){
                    curr_length += 1;
                    result =Math.max(result,curr_length);
                    nextNumber += 1;
                }

            }


        }

        return result;


    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(longestConsecutive(nums));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
