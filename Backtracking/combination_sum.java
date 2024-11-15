package Backtracking;

import java.util.*;

public class combination_sum {

    public static List<List<Integer>> result;

    public static void dfs(int i, List<Integer> currChannel , int target, int total,int[] candidates){

        if(total == target){
//            System.out.println( "voila" + currChannel);
            result.add( new ArrayList<>(currChannel));
            return;
        }
        if( total > target || i >= candidates.length){
//            System.out.println("nope"+ currChannel);
            return;
        }

        currChannel.add(candidates[i]);

//        System.out.println(currChannel);
        dfs(i, currChannel,target,total + candidates[i], candidates);
        currChannel.remove(currChannel.size() -1 );
        dfs(i+1, currChannel,target, total, candidates);

    }

    public static List<List<Integer>> combSum(int[] candidates, int target) {

        result = new ArrayList<>();

        dfs(0,new ArrayList<>(),target,0,candidates);

        return result;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {



            int[] candidates = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            System.out.println(combSum(candidates,target));



        }catch (Exception e){
            e.printStackTrace();
        }

//        runTestCase();
    }

//    public static void runTestCase(){
//
//        testcase(new int[]{2,3,6,7},7, ),1);
//    }
//    public static void testcase(int[] candidates,int target,int expected, int test){
//
//        List<List<Integer>> result = combSum(candidates,target);
//
//    }
}
