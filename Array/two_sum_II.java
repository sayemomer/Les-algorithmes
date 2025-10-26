package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class two_sum_II {

    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int left=0;
        int right=numbers.length -1;

        while (left < right){
            int curr = numbers[left] + numbers[right];
            if(curr == target){
                result[0] = left +1;
                result[1] = right +1;
                break;
            } else if (curr > target) {
                right--;

            }else {
                left++;
            }
        }

        return result;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            System.out.println(twoSum(arr,target));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
