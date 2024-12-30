package math_;

import java.util.Arrays;
import java.util.Scanner;

public class Rotate_Image_v2 {

    public static void rotate(int[][] matrix) {

        int left = 0;
        int right = matrix.length -1;

        while (left < right){
            int i = right -left;

            for (int j = 0; j < i; j++) {

                int top = left;
                int bottom = right;
                //top left
                int top_left_temp = matrix[top][left + j];

                // top right
                int top_right_temp = matrix[top + j ][right];
                matrix[top + j][right] = top_left_temp;

                //bottom right
                int bottom_right_temp = matrix[bottom][right - j];
                matrix[bottom][right - j] = top_right_temp;

                //bottom left
                int bottom_left_temp = matrix[bottom - j][left];
                matrix[bottom - j][left] = bottom_right_temp;

                matrix[top][left + j] = bottom_left_temp;

            }

            left++;
            right--;
        }

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int n = Integer.parseInt(sc.nextLine());
            int[][] grid = new int[n][n];

            for (int i = 0; i < n; i++) {
                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

           rotate(grid);

            for (int i = 0; i < n; i++) {

                String row = "";
                for (int j = 0; j < n; j++) {
                    row += grid[i][j] + " ";
                }
                System.out.println(row.trim());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
