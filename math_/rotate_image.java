package math_;

import java.util.Scanner;

public class rotate_image {

    public static void rotate(int[][] matrix) {


        int left = 0;
        int right = matrix.length -1;

        while (left<right){
            for (int i = 0; i < right -left ; i++) {

                int top = left;
                int bottom = right;

                //save the top left into a temp

                int top_left = matrix[top][left+i];

                //swap the bottom left -> top left

                matrix[top][left + i] = matrix[bottom -i ][left];

                //swap the bottom right -> bottom left

                matrix[bottom -i][left] = matrix[bottom][right -i];

                //swap the top right -> bottom left

                matrix[bottom][right-i] = matrix[top+i][right];

                //and finally top right to top left

                matrix[top+i][right] = top_left;
                
            }
            left++;
            right--;

        }



    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int row_col = Integer.parseInt(sc.nextLine());

            int[][] grid = new int[row_col][row_col];

            for (int i = 0; i < row_col; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < s.length; j++) {
                    grid[i][j] = Integer.parseInt(s[j]);
                }
            }

            rotate(grid);


            System.out.println("After rotation");

            for (int i = 0; i < row_col; i++) {
                String s = "";
                for (int j = 0; j < row_col; j++) {
                    s+= grid[i][j] +" ";
                }
                System.out.println(s);
            }



        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}

//5 1 9 11
//2 4 8 10
//13 3 6 7
//15 14 12 16
