package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class balancing_teams {

    public static Double balancing_team(int[] arr){

        if(arr.length == 0){
            return (double) 0;
        }

        Double min = Double.POSITIVE_INFINITY;

        int left =0 ;
        int right = arr.length -1;


        while (left <= right) {

            int[] leftarr = Arrays.copyOfRange(arr, 0, left);
            int[] rightarr = Arrays.copyOfRange(arr, left, arr.length);

            int diff = Math.abs(Arrays.stream(leftarr).sum() - Arrays.stream(rightarr).sum());

            min = Math.min(min, diff);

            left++;
        }

        return min;

    }
    public static void main(String[] args) {
//        try(Scanner sc = new Scanner(System.in)) {
//            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(balancing_team(arr));
//
//        }catch (Exception e){
//            System.out.println();
//            e.printStackTrace();
//        }
        runtestCases();
    }

    public static void runtestCases(){
        testCase(new int[]{3,1,4,1,5},2,1);
        testCase(new int[]{8,6,4,2},4,2);
        testCase(new int[]{1,2,3,4,5,6},1,3);
        testCase(new int[]{1},1,4);
        testCase(new int[]{1},1,5);
        testCase(new int[]{},0,6);
    }

    public static void testCase(int[] arr, int expected, int testcase){

        Double result = balancing_team(arr);

        if (result == expected){
            System.out.println(testcase + " " + "Passed");
        }else {
            System.out.println(testcase + " " + "---Failed----");
        }

    }
}
