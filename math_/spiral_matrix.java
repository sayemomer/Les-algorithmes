package math_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class spiral_matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> spiral_matrix = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length -1;

        while (top<= bottom && left <= right){

            //top left to top right
            for (int i = left; i <= right; i++) {
                spiral_matrix.add(matrix[top][i]);
            }
            top++;

            System.out.println(spiral_matrix);

            //top right to bottom

            for (int i = top; i <= bottom; i++) {

                spiral_matrix.add(matrix[i][right]);

            }
            right--;

            //bottom right to left

            if( top <= bottom){
                for (int i = right; i >= left; i--) {

                    spiral_matrix.add(matrix[bottom][i]);
                }

            }

            bottom--;

            if(left <= right){

                for (int i = bottom; i >= top; i--) {

                    spiral_matrix.add(matrix[i][left]);

                }

            }
            left++;

        }

        return spiral_matrix;

    }


    public static void main(String[] args) {



        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            int[][] grid = new int[row][col];

            for (int i = 0; i < grid.length; i++) {

                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(spiralOrder(grid));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
