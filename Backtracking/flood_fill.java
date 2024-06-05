package Backtracking;

import java.util.Scanner;

public class flood_fill {

    public static void backtrack(int[][] image, int row, int col, int color, int src_num) {

        // Boundary checks and base case to stop recursion
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != src_num) {
            return;
        }

        // Change the color of the current cell
        System.out.println(row);
        System.out.println(col);
        image[row][col] = color;

        // Recursively call backtrack on the adjacent cells
        System.out.println("moving down");
        backtrack(image, row + 1, col, color, src_num); // down
        System.out.println("moving up");
        backtrack(image, row - 1, col, color, src_num); // up
        System.out.println("moving right");
        backtrack(image, row, col + 1, color, src_num); // right
        System.out.println("moving left");
        backtrack(image, row, col - 1, color, src_num); // left
    }

    public static int[][] floodFill(int[][] image, int src_row, int src_col, int color) {

        int src_num = image[src_row][src_col];

        // If the source color is the same as the new color, return the image as is
        if (src_num == color) {
            return image;
        }

        // Start the flood fill algorithm
        backtrack(image, src_row, src_col, color, src_num);

        return image;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] image = new int[row][col];

            for (int i = 0; i < row; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < col; j++) {
                    image[i][j] = Integer.parseInt(s[j]);
                }
            }

            int src_row = Integer.parseInt(sc.nextLine());
            int src_col = Integer.parseInt(sc.nextLine());
            int color = Integer.parseInt(sc.nextLine());

            image = floodFill(image, src_row, src_col, color);

            System.out.println("New Image:");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(image[i][j] + " ");
                }
                System.out.println(); // Move to the next line after printing each row
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// test case

// 3
// 3
// 1 1 1
// 1 1 0
// 1 0 1
// 1
// 1
// 2
