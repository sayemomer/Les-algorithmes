package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class mystery_islands {
    public static boolean Island(String[][] grid,int row,int col){


        if(row <0 || row >= grid.length   || col <0 || col>= grid[0].length || grid[row][col].equals(" ") || grid[row][col].equals("0")){
            return false;
        }

        grid[row][col] = " ";

        return Island(grid,row -1 ,col) || Island(grid,row +1,col) || Island(grid,row,col+1) || Island(grid,row,col -1);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] row_col = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int row = row_col[0];
            int col = row_col[1];

            String[][] grid = new String[row][col];

            for (int i = 0; i < grid.length; i++) {
                grid[i] = sc.nextLine().split(" ");
            }

            int number_of_islands = 0;


            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    if(grid[i][j].equals("1")){
                        number_of_islands++;
                        Island(grid,i,j);
                    }
                }
            }

            System.out.println(number_of_islands);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
