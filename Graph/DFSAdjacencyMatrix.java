package Graph;
import java.util.Stack;

public class DFSAdjacencyMatrix {

    private int[][] adjacencyMatrix;
    private int numVertices;

    public DFSAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    public boolean dfs(int startVertex,int endVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        // Push the starting vertex onto the stack and mark it as visited
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

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
        int[][] adjacencyMatrix = {
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0}
        };





        DFSAdjacencyMatrix dfs = new DFSAdjacencyMatrix(adjacencyMatrix);

        System.out.println("DFS starting from vertex 0:");
        boolean x = dfs.dfs(0,3);

        if(x){
            System.out.println("\nPath exists");
        }
        else{
            System.out.println("\nPath does not exist");
        }

    }
    
}


