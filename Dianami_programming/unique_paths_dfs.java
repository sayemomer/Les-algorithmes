package Dianami_programming;

import java.util.Scanner;

/**
 * This solution limit TLE for m =19 , n=13 , USE DP then :p
 */

public class unique_paths_dfs {


    public static int dfs(int row, int col, int m, int n){

        //first check the boundary condition
        // if hits the bounday we will return 0
        // other wise its a valid route
        if(row > m -1 || col > n -1 || row < 0 || col <0) {
            return 0;
        }

        if(row == (m-1) && col == (n-1)){
            return 1;
        }

        return dfs(row +1, col,m,n) + dfs(row, col+1,m,n);

    }

    public static int uniquePaths(int m, int n) {

        return dfs(0,0,m,n);

    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int m = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());

            System.out.println(uniquePaths(m,n));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
