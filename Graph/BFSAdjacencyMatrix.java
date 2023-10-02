package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public BFSAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        // Mark the starting vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Visit all adjacent vertices that are not visited yet
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0}
        };

        BFSAdjacencyMatrix bfs = new BFSAdjacencyMatrix(adjacencyMatrix);

        System.out.println("BFS starting from vertex 0:");
        bfs.bfs(0);

        System.out.println("\nBFS starting from vertex 3:");
        bfs.bfs(3);
    }
}
