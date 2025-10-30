package math_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class spiral {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiralPrint = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length -1;
        int top = 0;
        int bottom = matrix.length -1;

//        System.out.println(left);
//        System.out.println(right);
//        System.out.println(top);
//        System.out.println(bottom);

        while (left <= right && top <= bottom){
            //top  row
            for (int i = left; i <= right; i++) {

//                if(matrix[top][i] == 6){
//                    System.out.println("--");
//                    System.out.println("hi" + matrix[top][i]);
//                }
                spiralPrint.add(matrix[top][i]);
            }
            //increment the top
            top++;

            //right column
            for (int i = top; i <= bottom; i++) {

//                if(matrix[i][right] == 6){
//                    System.out.println("**");
//                    System.out.println("hi" + matrix[i][right]);
//                }
                spiralPrint.add(matrix[i][right]);
            }
            right--;
            //bottom

            if(top <= bottom){

                for (int i = right; i >= left; i--) {
//                    if(matrix[bottom][i] == 6){
//                        System.out.println("^^");
//                        System.out.println(top);
//                        System.out.println(bottom);
//                        System.out.println("hi" + matrix[bottom][i]);
//                    }
                    spiralPrint.add(matrix[bottom][i]);
                }

            }



            bottom--;

//            System.out.println(left);
//            System.out.println(right);
//            System.out.println(top);
//            System.out.println(bottom);


            if(left <= right){

                for (int i = bottom; i >= top; i--) {
//                if(matrix[i][left] == 6){
//                    System.out.println("++");
//                    System.out.println("hi" + matrix[i][left]);
//                }
                    spiralPrint.add(matrix[i][left]);

                }

            }

            left++;
            
        }

        return spiralPrint;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] grid = new int[row][col];

            for (int i = 0; i < grid.length; i++) {

                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(spiralOrder(grid));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
