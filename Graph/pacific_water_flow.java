package Graph;

import java.util.*;

public class pacific_water_flow {


    // 1 2
    // 4 3
    
    public static Set<List<Integer>> pacific_visit_set = new HashSet<>();
    public static Set<List<Integer>> atlantic_visit_set = new HashSet<>();

    public static void dfs(int row, int col,Set<List<Integer>> visitSet,int[][] heights,int prevHight){

        if(visitSet.contains(Arrays.asList(row,col)) || row <0 || row == heights.length || col < 0 || col == heights[0].length || heights[row][col] < prevHight){
            return;
        }

        visitSet.add(Arrays.asList(row,col));

        //then call DFS for this in all direction

        dfs(row +1,col,visitSet,heights,heights[row][col]);
        dfs(row -1,col,visitSet,heights,heights[row][col]);
        dfs(row,col +1 ,visitSet,heights,heights[row][col]);
        dfs(row,col -1,visitSet,heights,heights[row][col]);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> target_row = new ArrayList<>();

        //first we call dfs for both pacific and atlantic , top bottom

        for (int i = 0; i < heights[0].length; i++) {
            dfs(0,i,pacific_visit_set,heights,heights[0][i]);
            dfs(heights.length - 1,i,atlantic_visit_set,heights,heights[heights.length - 1][i]);
        }

        for (int i = 0; i < heights.length; i++) {
            dfs(i,0,pacific_visit_set,heights,heights[i][0]);
            dfs(i ,heights[0].length -1 ,atlantic_visit_set,heights,heights[i][heights[0].length - 1]);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if(pacific_visit_set.contains(Arrays.asList(i,j)) && atlantic_visit_set.contains(Arrays.asList(i,j))){
                    target_row.add(Arrays.asList(i,j));
                }
            }

        }

        return target_row;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] map = new int[row][col];

            for (int i = 0; i < map.length; i++) {
                map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(pacificAtlantic(map));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
