package Dianami_programming;

import java.util.Scanner;

/**
 * This solution gets TLE for n=44
 */

public class climb_stair_dfs {

    public static int dfs(int i,int n){

        if(i == n){
            return 1;
        }else if( i> n){
            return 0;
        }else {
            return dfs(i+1,n) + dfs(i+2,n);
        }

    }

    public static int climbStairs(int n) {
        return dfs(0,n);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int n = Integer.parseInt(sc.nextLine());
            System.out.println(climbStairs(n));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
