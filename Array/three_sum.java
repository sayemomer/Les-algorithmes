package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class three_sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            //first we take single
            //then set two pointer

            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;

            while (left<right){

                int curr = nums[i] + nums[left] + nums[right];
                if(curr == 0 ){
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    // I need something here to check for duplicates , before inc pointer
                    left++;
                    while (nums[left] == nums[left -1] && left < right){
                        left++;
                    }
                } else if (curr > 0) {
                    right--;
                }else {
                    left++;
                }
            }

        }

        return triplets;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(threeSum(arr));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
