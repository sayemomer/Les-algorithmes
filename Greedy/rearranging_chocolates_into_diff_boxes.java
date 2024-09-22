package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class rearranging_chocolates_into_diff_boxes {

    public static int rearrange(int num_of_chocolate,int[] chocolate_packs, int num_of_box, int[] boxes ){

        int result = 0;

        int total_choc = Arrays.stream(chocolate_packs).sum();
        int total_box = Arrays.stream(boxes).sum();

        if(total_choc> total_box){
            return -1;
        }

        Arrays.sort(boxes);

        int box_pointer = num_of_box -1;

        while (total_choc >0 && box_pointer >=0 ){

            total_choc = total_choc - boxes[box_pointer];
            box_pointer--;
            result++;

        }

        return result;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int num_of_chocolate = Integer.parseInt(sc.nextLine());
            int[] chocolate_packs = new int[0];

            if(num_of_chocolate >0){
               chocolate_packs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int num_of_box = Integer.parseInt(sc.nextLine());
            int[] boxes = new int[0];

            if(num_of_box> 0){
                boxes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }


            System.out.println(rearrange(num_of_chocolate,chocolate_packs,num_of_box,boxes));


        }catch (Exception e){
            e.printStackTrace();
        }

//        runTestCases();
    }

//    public static void runTestCases() {
//        // Test Case 1: Basic case, exact fit
//        testCase(3, new int[]{2, 3, 1}, 5, new int[]{3, 2, 2, 4, 1}, 2);
//
//        // Test Case 2: Exceeding total capacity (should return -1)
//        testCase(3, new int[]{4, 2, 5}, 2, new int[]{5, 4}, -1);
//
//        // Test Case 3: Minimum boxes required
//        testCase(3, new int[]{3, 2, 1}, 4, new int[]{2, 3, 1, 5}, 2);
//
//        // Test Case 4: No chocolates
//        testCase(0, new int[]{}, 3, new int[]{2, 3, 4}, 0);
//
//        // Test Case 5: No boxes
//        testCase(3, new int[]{2, 3, 4}, 0, new int[]{}, -1);
//
//        // Test Case 6: Large input, exact fit
//        testCase(5, new int[]{5, 10, 3, 7, 2}, 6, new int[]{10, 12, 7, 6, 5, 2}, 3);
//
//        // Test Case 7: One large box
//        testCase(4, new int[]{2, 2, 2, 2}, 2, new int[]{10, 3}, 1);
//
//        testCase(3, new int[]{3,1,2}, 5, new int[]{2,3,1,2,4}, 2);
//
//        testCase(0, new int[]{}, 0, new int[]{}, 0);
//    }
//
//    // Method to test individual test cases
//    public static void testCase(int num_of_chocolate, int[] chocolate_packs, int num_of_box, int[] boxes, int expected) {
//        int result = rearrange(num_of_chocolate, chocolate_packs, num_of_box, boxes);
//        System.out.println("Test Case Result -> Expected: " + expected + ", Got: " + result);
//        if (result == expected) {
//            System.out.println("Test passed!");
//        } else {
//            System.out.println("---->Test failed!");
//        }
//    }
}
