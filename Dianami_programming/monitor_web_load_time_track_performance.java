package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class monitor_web_load_time_track_performance {

    public  static  String findLIS(int[] performanceMatrics,StringBuilder res){

        int[] LIS = new int[performanceMatrics.length];

        Arrays.fill(LIS,1);

        String x = "";

        for (int i = performanceMatrics.length -1; i >=0 ; i--) {

            x +=  performanceMatrics[(performanceMatrics.length -1) -i] + " ";

            for (int j = i+1 ; j < performanceMatrics.length  ; j++) {

                if(performanceMatrics[i] < performanceMatrics[j]){
                    LIS[i] = Math.max(LIS[i] , 1 + LIS[j]);
                }else{
                    break;
                }

            }
            
        }

       int max = Arrays.stream(LIS).max().orElseThrow();

        return res.append(x.trim()).append("\n").append(max).toString();
    }


    public static String trackStability(int[] arr){
        StringBuilder result = new StringBuilder();

        int curr = arr.length -1;

        int[] performancemetrics = new int[arr.length];

        while (curr >=0){

            int j= curr-1;
            int inprovementdays =1;

            while (j>=0){

                if(arr[j] <= arr[curr]){
                    j--;
                    inprovementdays++;
                }else {
                    performancemetrics[curr] = inprovementdays;
                    break;
                }
                performancemetrics[curr] = inprovementdays;
            }

            curr--;
        }

        performancemetrics[curr+1] = 1;

        result = new StringBuilder(findLIS(performancemetrics, result));

        return result.toString();
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int[] loadtimes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(trackStability(loadtimes));



        }catch (Exception e){
            e.printStackTrace();
        }

//        runTestCases();
    }

//    public static void runTestCases(){
//        testcase(new int[]{400,300,250,275,250,300,350},"1 1 1 2 1 5 6\n3",1);
//        testcase(new int[]{50,40,45,60,70,60},"1 1 2 4 5 1\n4",2);
//    }
//
//    public static void testcase(int[] arr,String expected,int testcase){
//
//        String result = trackStability(arr);
////
////        System.out.println(expected);
////        System.out.println(result);
//
//        if(result.equals(expected)){
//            System.out.println(testcase +" "+"Passed");
//        }else {
//            System.out.println(testcase +" "+"---Failed---");
//        }
//
//    }
}
