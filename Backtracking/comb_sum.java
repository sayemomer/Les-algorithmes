package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class comb_sum {

    public static List<List<Integer>> result;


    public static void dfs(int index,int[] list,int target,List<Integer> curr,int curr_sum){



        if(curr_sum == target){
            result.add( new ArrayList<>(curr));
            return;
        } else if (curr_sum >  target || index >= list.length ) {
            return;

        }

        curr.add(list[index]);

        dfs(index,list,target,curr,curr_sum + list[index]);
        curr.remove(curr.size() -1);
        dfs(index +1 ,list,target,curr,curr_sum);

    }

    public static List<List<Integer>> combinations_sum(int[] list, int target){
        result = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        dfs(0,list,target,curr,0);

        return result;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            System.out.println(combinations_sum(list,target));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
