package Graph;

import java.util.*;

public class number_of_islands {

    //0 0


    public static void dfs(char[][] grid,int row, int col){

        Set<String> visit_set = new HashSet<>();
        visit_set.add(row + " " +col);

        Queue<int[]> visited = new LinkedList<>();
        visited.add(new int[]{row,col});

        int[][] movement = {
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };

        while (!visited.isEmpty()){

            int[] new_element = visited.poll();

            for (int i = 0; i < movement.length; i++) {
                    int new_row = new_element[0]+ movement[i][0];
                    int new_col = new_element[1] + movement[i][1];

                    if( (new_row < grid.length && new_row >=0) && (new_col < grid[0].length
                    && new_col >= 0) && grid[new_row][new_col] == '1' && !visit_set.contains(new_row + " "+ new_col) ){
                        visited.add(new int[]{new_row,new_col});
                        visit_set.add(new_row + " " +new_col);
                        grid[new_row][new_col] = '0'; // Mark as visited
                }

            }

        }

    }

    public static int numIslands(char[][] grid) {

        int islands =0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }

        }

        return islands;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            char[][] grid = new char[row][col];

            for (int i = 0; i < grid.length; i++) {

                String[] r = sc.nextLine().split(" ");
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = r[j].charAt(0);
                }

            }

            System.out.println(numIslands(grid));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//        4
//        5
//        1 1 1 1 0
//        1 1 0 1 0
//        1 1 0 0 0
//        0 0 0 0 0
