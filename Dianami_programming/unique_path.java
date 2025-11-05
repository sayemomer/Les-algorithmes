package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class unique_path {

    public static int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];

        for (int[] row : grid){
            Arrays.fill(row,1);
        }

        for (int i = grid.length - 2 ; i >=0 ; i--) {
            for (int j = grid[0].length - 2 ; j >=0 ; j--) {
                grid[i][j] = grid[i][j+1] + grid[i+1][j];
            }
        }

        return grid[0][0];
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
