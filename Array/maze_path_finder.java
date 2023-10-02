import java.util.Scanner;
import java.util.Stack;

public class maze_path_finder {

    public static boolean dfs(int startVertex, int endVertex, int[][] adjacencyMatrix, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        // Push the starting vertex onto the stack and mark it as visited
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            // Visit all adjacent vertices that are not visited yet
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    if (i == endVertex) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            String rowcol = sc.nextLine();
            String[] rowcolArr = rowcol.split(" ");
            int row = Integer.parseInt(rowcolArr[0]);
            int col = Integer.parseInt(rowcolArr[1]);
            int startIndex = 0;
            int endEndex = 0;

            int[][] maze = new int[row][col];

            int[][] adjMatrix = new int[row * col][row * col];

            for (int i = 0; i < row; i++) {
                String mazeLine = sc.nextLine();
                String[] mazeLineArr = mazeLine.split(" ");
                for (int j = 0; j < col; j++) {
                    maze[i][j] = Integer.parseInt(mazeLineArr[j]);
                }
            }

            int[][] mapMatrix = new int[row][col];
            int counter = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mapMatrix[i][j] = counter;
                    counter++;

                }
            }

            // print the maze
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    if (maze[i][j] == 0) {
                        startIndex = mapMatrix[i][j];
                    }
                    if (maze[i][j] == 2) {
                        endEndex = mapMatrix[i][j];
                    }

                    if (i + 1 < row && maze[i + 1][j] != -1) {
                        adjMatrix[mapMatrix[i][j]][mapMatrix[i + 1][j]] = 1;
                    }
                    if (i - 1 >= 0 && maze[i - 1][j] != -1) {
                        adjMatrix[mapMatrix[i][j]][mapMatrix[i - 1][j]] = 1;
                    }
                    if (j + 1 < col && maze[i][j + 1] != -1) {
                        adjMatrix[mapMatrix[i][j]][mapMatrix[i][j + 1]] = 1;
                    }
                    if (j - 1 >= 0 && maze[i][j - 1] != -1) {
                        adjMatrix[mapMatrix[i][j]][mapMatrix[i][j - 1]] = 1;
                    }
                }
            }

            boolean x = dfs(startIndex, endEndex, adjMatrix, row * col);
            if (x) {
                System.out.println("Found");
            } else {
                System.out.println("Not found");
            }

            // for each cell in the maze, check if we can travel to right ,left , up and
            // down cell

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
