package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class set_matrix_zeroes {

    public static void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0){

                        row[i] = 1;
                        col[j] = 1;
                    }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] grid = new int[row][col];

            for (int i = 0; i < grid.length; i++) {

                grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            setZeroes(grid);

            System.out.println("After setZeros");

            for (int i = 0; i < grid.length; i++) {
                String ro = "";
                for (int j = 0; j < grid[0].length; j++) {
                    ro += grid[i][j] + " ";
                }
                System.out.println(ro);

            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
