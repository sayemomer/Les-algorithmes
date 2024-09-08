package Backtracking;

import java.util.*;

public class maze_path_finder {


    public static boolean dfs(int row, int col, int[][] grid,Set<List<Integer>> visitset){

        //if the current grid number is 2 we found the path

        if(row < 0 || row >= grid.length || col<0 || col >=grid[0].length || grid[row][col] == -1 || visitset.contains(Arrays.asList(row, col))){
            return false;
        }


        if(grid[row][col] == 2){
            return true;
        }

        visitset.add(Arrays.asList(row, col));

        boolean found = dfs(row +1 ,col,grid,visitset) ||
                dfs(row -1 ,col,grid,visitset) ||
                dfs(row,col +1 ,grid,visitset) ||
                dfs(row,col -1 ,grid,visitset);

        visitset.remove(Arrays.asList(row, col));
        return found;
    }

    public static StringBuilder find_maze(int row, int col ,int[][] grid){
        StringBuilder result = new StringBuilder();
        Set<List<Integer>> visit_set = new HashSet<>();

        if(dfs(row,col,grid,visit_set)){
            result.append("Found");
        }else {
            result.append("Not Found");
        }

        return result;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] dimensions = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = dimensions[0];
            int col = dimensions[1];


            int[][] grid = new int[row][col];


            for (int i = 0; i < grid.length; i++) {

                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(find_maze(0,0,grid));



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
