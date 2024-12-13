package Backtracking;

import java.util.Scanner;

public class count_the_number_of_hops {

    public static int numsofHops;

    public static int[] jumps = new int[]{1,2,3};

    public static void dfs( int target, int total){

        if(total == target){
            numsofHops++;
            return;
        }
        if( total > target ){
            return;
        }

        for (int i = 0; i < jumps.length; i++) {

            dfs(target,total + jumps[i]);

        }

    }

    public static int numberofHops(int n){

        if(n <=0 ){
            return 0;
        }

        numsofHops = 0;

        dfs( n , 0);

        return numsofHops;

    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());

            System.out.println(numberofHops(n));


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
