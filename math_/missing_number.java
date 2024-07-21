package math_;

import java.util.Arrays;
import java.util.Scanner;

public class missing_number {

    public static int missingNumber(int[] nums) {

        int N = nums.length;

        int sum_of_series = (N * (N+1))/2;
        int sum_of_nums = Arrays.stream(nums).sum();

        return sum_of_series - sum_of_nums;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(missingNumber(nums));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
