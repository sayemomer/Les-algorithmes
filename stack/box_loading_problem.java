package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class box_loading_problem {

    public static int max_order(int[] order){
        int max = 0;

        return max;
    }
    public static void main(String[] args) {
//        try(Scanner sc = new Scanner(System.in)) {
//
//            int[] order = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(max_order(order));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        runTestCase();
    }

    public static void runTestCase(){
        testCase(new int[]{4,3,1,2,5},2,1);
        testCase(new int[]{5,4,3,2,1},5,2);
        testCase(new int[]{5,1,4,3,2},1,3);
    }

    public static void testCase(int[] order, int expected, int test){

        int result = max_order(order);

        System.out.println(result);

        if(result == expected){
            System.out.println(test + " " + "passed");
        }else {
            System.out.println(test + " " + "--Failed--");
        }

    }
}
