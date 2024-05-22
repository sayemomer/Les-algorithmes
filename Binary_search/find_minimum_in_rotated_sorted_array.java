package Binary_search;
import java.util.Scanner;

public class find_minimum_in_rotated_sorted_array {


    public static int findMin(int[] nums) {

        int min = nums[0];

        //then we declare the pointers

        //2 1

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {

            if(nums[left] <= nums[right]){
                min =  Math.min(min, nums[left]);
                break;
            }

            int mid = (right + left) / 2;

            min = Math.min(min, nums[mid]);

            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }

        return min;
    }


    public static void main(String[] args) {


        try(Scanner sc = new Scanner(System.in)) {

            String[] nums_s = sc.nextLine().split(" ");
            int[] nums = new int[nums_s.length];

            for (int i = 0; i < nums_s.length; i++) {
                nums[i] = Integer.parseInt(nums_s[i]);
            }

            System.out.println(findMin(nums));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
