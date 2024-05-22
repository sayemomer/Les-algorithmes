package Binary_search;

import java.util.Scanner;

public class search_in_rotated_sorted_array {

    public static int search(int[] nums, int target) {

        int target_index = -1;
        int left = 0;
        int right = nums.length -1;

        //4 5 6 7 0 1 2
        //0
        //0 1
        // 0 1 2

        while (left <= right) {

            int mid = (left + right) / 2;

            if(nums[mid] == target){
                target_index = mid;
                break;
            }

            //so first er check the mid value is less or greater than the leftmost value

            if(nums[left] <= nums[mid]){

                if(target> nums[mid] || target < nums[left]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }

            }else{
                if(target < nums[mid] || target > nums[right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            
        }


        return target_index;
        
    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] nums_s = sc.nextLine().split(" ");
            int[] nums = new int[nums_s.length];
            int target = Integer.parseInt(sc.nextLine());


            for (int i = 0; i < nums_s.length; i++) {
                nums[i] = Integer.parseInt(nums_s[i]);
            }

            System.out.println(search(nums,target));

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
