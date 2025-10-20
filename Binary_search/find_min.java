package Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class find_min {

    public static int findMin(int[] nums) {

        int min = nums[0];

        int left = 0;
        int right = nums.length -1 ;

        while (left<=right){

            if(nums[left] <= nums[right]){
                min = nums[left];
                break;
            }

            int mid = (left + right)/2;

            System.out.println(mid);

            min = Math.min(min, nums[mid]);

            System.out.println(min);

            if(nums[mid] >= nums[left]){
                left = mid + 1 ;
            }else {
               right = mid -1;
            }


        }

        return min;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(findMin(nums));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
