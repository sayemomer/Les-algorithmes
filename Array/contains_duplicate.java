package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class contains_duplicate {

    public static boolean containsDuplicate(int[] nums) {
        boolean contains = false;

        Set<Integer> container = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if(container.contains(nums[i])){
                return true;
            }else {
                container.add(nums[i]);
            }

        }

        return contains;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(containsDuplicate(arr));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
