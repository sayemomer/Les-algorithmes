import java.util.Arrays;
import java.util.Scanner;

public class Kth_largest_element_in_an_array {

    public static int index;

    public static int quickSelect(int[] nums,int left, int right){

//        System.out.println(left);
//        System.out.println(right);



        int p = left;
        int pivot = right;


        for (int i = left; i < right; i++) {

            if (nums[i] <= nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
            
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        if(p<index){

            return quickSelect(nums,p+1,right );
        }else if (p>index){

            return quickSelect(nums, left, p-1);
        }else {
            return nums[p];
        }

    }

    public static int findKthLargest(int[] nums, int k) {
        index = nums.length - k;

         return quickSelect(nums,0,nums.length -1);

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(sc.nextLine());

            System.out.println(findKthLargest(nums,k));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
