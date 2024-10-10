package math_;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class matrix_rotation_layer_exploration {

    public static void rotate_layer(int[][] grid){

        int left = 0;
        int right = grid[0].length - 1;

        String result= "";

        while (left<=right){
            int top = left;
            int bottom = right;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i <= right -left; i++) {

                int topleft = grid[top][left + i];
                int bottomLeft = grid[bottom - i][left];
                int bottomright = grid[bottom][right -i];
                int topright = grid[top][right -i];

                min =Math.min(min,Arrays.stream(new int[]{topleft, bottomLeft, bottomright, topright}).min().orElseThrow()) ;
                max =Math.max(max,Arrays.stream(new int[]{topleft, bottomLeft, bottomright, topright}).max().orElseThrow()) ;

                //top left in temp

                int temp = grid[top][left + i];

                //bottom left into top left

                grid[top][left + i] = grid[bottom - i][left];

                //right bottom into bottom left

                grid[bottom -i ][left] = grid[bottom][right -i];

                //top right into bottom right

                grid[bottom][right -i] = grid[top][right -i];

                //to right to the temp

                grid[top ][right -i] = temp;


            }

            int x = max -min;

            result+= x+" ";

            left++;
            right--;
        }

        System.out.println(result.trim());

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int len = Integer.parseInt(sc.nextLine());
            int[][] grid = new int[len][len];

            for (int i = 0; i < grid.length; i++) {
                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            rotate_layer(grid);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
