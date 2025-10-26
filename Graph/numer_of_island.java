package Graph;

import java.util.*;

public class numer_of_island {

    public static void dfs(int row, int col, char[][] grid){

        //boundary check

        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length -1 || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(row +1 , col,grid);
        dfs(row -1, col,grid);
        dfs(row, col+1,grid);
        dfs(row, col-1,grid);
    }

    public static int numIslands(char[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] =='1'){
                        dfs(i,j,grid);
                        islands++;
                    }
            }

        }
        return islands;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int m = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());

            char[][] grid = new char[m][n];

            for (int i = 0; i < grid.length; i++) {
                String[] r = sc.nextLine().split(" ");
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = r[j].charAt(0);
                }
            }

            System.out.println(numIslands(grid));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
