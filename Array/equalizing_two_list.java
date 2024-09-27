package Array;

import java.util.*;

public class equalizing_two_list {


    public static List<Integer> arr_1;
    public static List<Boolean> atol1;
    public static List<Integer> arr_2;
    public static List<Boolean> atol2;

    public static void helper(String ar1, String ar2, int max){

        String[] arr1 = ar1.split(" ");
        String[] arr2 = ar2.split(" ");

        for (int i = 0; i < arr1.length; i++) {

            char[] m = arr1[i].toCharArray();
            String k = "";
            boolean is_atol = false;

            for (char x : m){
                if (x =='*'){
                    is_atol = true;
                }else {
                    k+=x;
                }
            }

            if(is_atol){
                arr_1.add(Integer.parseInt(k));
                atol1.add(false);
            }else {
                arr_1.add(Integer.parseInt(String.valueOf(arr1[i])));
                atol1.add(true);
            }

        }

        for (int i = 0; i < arr2.length; i++) {

            char[] m = arr2[i].toCharArray();
            String k = "";
            boolean is_atol = false;

            for (char x : m){
                if (x =='*'){
                    is_atol = true;
                }else {
                    k+=x;
                }
            }

            if(is_atol){
                arr_2.add(Integer.parseInt(k));
                atol2.add(false);
            }else {
                arr_2.add(Integer.parseInt(String.valueOf(arr2[i])));
                atol2.add(true);
            }


        }
    }


    public static int maxSwap(String arr1, String arr2, int max){

        arr_1 = new ArrayList<>();
        arr_2 = new ArrayList<>();
        atol1 = new ArrayList<>();
        atol2 = new ArrayList<>();

        int result = -1;

        helper(arr1,arr2,max);

        int sum1 = arr_1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = arr_2.stream().mapToInt(Integer::intValue).sum();

//        System.out.println(arr_1);
//        System.out.println(arr_2);
//
//        System.out.println(sum1);
//        System.out.println(sum2);

//        System.out.println(arr_1);
//        System.out.println(arr_2);
//
//        System.out.println(sum1);
//        System.out.println(sum2);

        if(sum1 == sum2){

            return 0;
        }

        result = 0;
        int m = max;
        boolean canMove = true;

        while (m > 0 && sum1 != sum2 && canMove) {
            canMove = false;

            if (sum1 > sum2) {
                // Try to move from arr_1 to arr_2
                // First, rearrange priority elements at the front
                while (!atol1.isEmpty() && !atol1.get(0)) {
                    // Rearranging priority elements (no move cost)
                    int x = arr_1.remove(0);
                    atol1.remove(0);
                    arr_1.add(x);
                    atol1.add(false);
                    canMove = true; // We did rearrange
                }

                // Now, if the front element is movable
                if (!arr_1.isEmpty() && atol1.get(0)) {
                    int x = arr_1.remove(0);
                    atol1.remove(0);
                    arr_2.add(x);
                    atol2.add(true);
                    sum1 -= x;
                    sum2 += x;
                    m--;
                    result++;
                    canMove = true;
                }
            } else {
                // Try to move from arr_2 to arr_1
                // First, rearrange priority elements at the front
                while (!atol2.isEmpty() && !atol2.get(0)) {
                    // Rearranging priority elements (no move cost)
                    int x = arr_2.remove(0);
                    atol2.remove(0);
                    arr_2.add(x);
                    atol2.add(false);
                    canMove = true; // We did rearrange
                }

                // Now, if the front element is movable
                if (!arr_2.isEmpty() && atol2.get(0)) {
                    int x = arr_2.remove(0);
                    atol2.remove(0);
                    arr_1.add(x);
                    atol1.add(true);
                    sum2 -= x;
                    sum1 += x;
                    m--;
                    result++;
                    canMove = true;
                }
            }

            // If no rearrangement or move was possible
            if (!canMove) {
                break;
            }
        }


        if (sum1 == sum2) {
            return result;
        } else {
            return -1;
        }

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String arr1 = sc.nextLine();
            String arr2 = sc.nextLine();
            int max = Integer.parseInt(sc.nextLine());

            System.out.println(maxSwap(arr1,arr2,max));

        }catch (Exception e){
            e.printStackTrace();
        }

//        runtestCases();

    }


//    public static void runtestCases(){
//
//        testcase("4 1* 6 8 3* 7 2","12 2* 5 3 6 4 1",15,8,1);
//        testcase("1 2* 3","5 6* 1",4,-1,2);
//        testcase("1 2* 3","4 1 1*",4,0,3);
//        testcase("1* 1* 1*","1* 1* 1*",4,0,4);
//
//
//        testcase("5 2 7* 3 1 4* 6","8 3* 2 9 5* 1 7",10,6,5);
////        testcase("1* 1* 1*","1* 1* 1*",4,0,4);
//
//    }
//
//    public static void testcase(String x ,String y , int max , int expected, int testcase){
//
//        int result = maxSwap(x,y,max);
//
//        System.out.println(result);
//
//        if (result == expected){
//            System.out.println(testcase+" "+"passed");
//        }else {
//            System.out.println(testcase+" "+"-----failed----");
//        }
//
//
//    }
}
