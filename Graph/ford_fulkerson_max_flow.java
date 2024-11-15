package Graph;
import java.util.*;

public class ford_fulkerson_max_flow {

    // Number of vertices in the graph
    private final int V;

    public ford_fulkerson_max_flow(int V) {
        this.V = V;
    }

    // Helper method to perform DFS in the residual graph to find an augmenting path
    private boolean dfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;
        parent[source] = -1;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int v = 0; v < V; v++) {
                // If not yet visited and there is residual capacity
                if (!visited[v] && residualGraph[u][v] > 0) {
                    parent[v] = u;
                    stack.push(v);
                    visited[v] = true;

                    // If we reached the sink in DFS starting from source
                    if (v == sink) return true;
                }
            }
        }
        return false;
    }

    // Ford-Fulkerson Algorithm using Adjacency List
    public int fordFulkersonList(List<List<Edge>> graph, int source, int sink) {
        // Create residual graph from the adjacency list representation
        int[][] residualGraph = new int[V][V];

        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.get(u)) {
                residualGraph[u][edge.v] = edge.capacity;
            }
        }

        int maxFlow = 0;
        int[] parent = new int[V];  // Array to store the path

        // Augment the flow while there is a path from source to sink
        while (dfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            // Find the maximum flow in the path filled by DFS
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Update residual capacities of the edges and reverse edges along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    // Edge class for adjacency list representation
    static class Edge {
        int v, capacity;

        public Edge(int v, int capacity) {
            this.v = v;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        int V = 6;  // Example graph with 6 vertices
        ford_fulkerson_max_flow fordFulkerson = new ford_fulkerson_max_flow(V);

        int source = 0, sink = 5;

        // Example graph as Adjacency List
        List<List<Edge>> graphList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graphList.add(new ArrayList<>());
        }

        // Add edges to the graph
        graphList.get(0).add(new Edge(1, 16));
        graphList.get(0).add(new Edge(2, 13));
        graphList.get(1).add(new Edge(2, 10));
        graphList.get(1).add(new Edge(3, 12));
        graphList.get(2).add(new Edge(1, 4));
        graphList.get(2).add(new Edge(4, 14));
        graphList.get(3).add(new Edge(2, 9));
        graphList.get(3).add(new Edge(5, 20));
        graphList.get(4).add(new Edge(3, 7));
        graphList.get(4).add(new Edge(5, 4));

        System.out.println("Maximum Flow using Adjacency List: " +
                fordFulkerson.fordFulkersonList(graphList, source, sink));
    }
}
