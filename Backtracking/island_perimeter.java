package Backtracking;

import java.util.Scanner;

public class island_perimeter {

    public static int backtrack(int[][] grid, int row, int col) {
        // Boundary checks
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1; // Water or edge contributes to perimeter
        }
        
        if (grid[row][col] == -1) {
            return 0; // Already visited cell, no contribution to perimeter
        }

        // Mark the cell as visited
        grid[row][col] = -1;

        // Recursively check all four directions and sum up the perimeter
        int perimeter = 0;

        perimeter += backtrack(grid, row + 1, col); // Down
        perimeter += backtrack(grid, row - 1, col); // Up
        perimeter += backtrack(grid, row, col + 1); // Right
        perimeter += backtrack(grid, row, col - 1); // Left

        return perimeter;
    }

    public static int islandPerimeter(int[][] grid) {
        int island_perimeter = 0;

        // Traverse the grid to find the first piece of land (1)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // Start backtracking from the first piece of land
                    island_perimeter += backtrack(grid, i, j);
                }
            }
        }

        return island_perimeter;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] grid = new int[row][col];

            for (int i = 0; i < row; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < col; j++) {
                    grid[i][j] = Integer.parseInt(s[j]);
                }
            }

            System.out.println(islandPerimeter(grid));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//test case

// 4
// 4
// 0 1 0 0
// 1 1 1 0
// 0 1 0 0
// 1 1 0 0

// 1
// 1
// 1
