package Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class search_in_rotated_sorted_arr_2 {

    public static boolean search(int[] nums, int target) {

        boolean target_index_found = false;
        int left = 0;
        int right = nums.length -1;

        Arrays.sort(nums);

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        while (left <= right) {

            int mid = (left + right) / 2;

            if(nums[mid] == target){
                target_index_found = true;
                break;
            }

            if(target <= nums[mid]){

                //left portion of the arra
                right = mid - 1;

            }
            else{

                left = mid + 1;
            }

        }

        return target_index_found;

    }


//    public static boolean search(int[] nums, int target) {
//
//        boolean target_index_found = false;
//        int left = 0;
//        int right = nums.length -1;
//
//        Arrays.stream(nums).sorted();
//
//
//
//        while (left <= right) {
//
//            int mid = (left + right) / 2;
//
//            if(nums[mid] == target){
//                target_index_found = true;
//                break;
//            }
//
//            //so first er check the mid value is less or greater than the leftmost value
//
//            //this one is to check which portion to process first
//
//            if(nums[left] <= nums[mid]){
//
//                //left portion of the array
//
//                if(target> nums[mid] || target < nums[left]){
//                    left = mid + 1;
//                }else{
//
//                    // aita taile aikhanei ache
//                    right = mid - 1;
//                }
//
//            }
//            else{
//
//                //right portion of the array
//
//                //0 1 2
//                //1
//
//                if(target < nums[mid] || target > nums[right]){
//                    right = mid - 1;
//                }else{
//                    left = mid + 1;
//                }
//            }
//
//        }
//
//
//        return target_index_found;
//
//    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] nums_s = sc.nextLine().split(" ");
            int[] nums = new int[nums_s.length];
            int target = Integer.parseInt(sc.nextLine());


            for (int i = 0; i < nums_s.length; i++) {
                nums[i] = Integer.parseInt(nums_s[i]);
            }

            System.out.println(search(nums,target));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
