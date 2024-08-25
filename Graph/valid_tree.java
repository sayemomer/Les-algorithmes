package Graph;

import java.util.*;

public class valid_tree {

    public static HashMap<Integer,ArrayList<Integer>> graphmap = new HashMap<>();
    public  static Set<Integer> visitset = new HashSet<>();

    public static boolean dfs(int curr_node,int prev_node){

        if(visitset.contains(curr_node)){
            return false;
        }

        visitset.add(curr_node);

        //now we need to travarse the conected states of this current node

        ArrayList<Integer> connections = graphmap.get(curr_node);
//        System.out.println(connections);

        for (int i = 0; i < connections.size(); i++) {

            //we need something to stop loop for bidirection, thats why we introduced the prev_node
            //if the curr node is the prev_node we can skip it by continuing the loop
//
//            System.out.println("curr_node" + curr_node);
//            System.out.println("prev_node" + prev_node);

            int next_node = connections.get(i);

//            System.out.println("next_node" + next_node);

            if(prev_node == next_node) {
                continue;
            }

            if(!dfs(next_node,curr_node)){
                return false;
            }

        }

        return true;

    }


    public static boolean validTree(int n, int[][] edges) {

//        n = 5
//        edges = [[0, 1], [0, 2], [0, 3], [1, 4]]



        for (int i = 0; i < n; i++) {
            graphmap.put(i,new ArrayList<>());
        }

        //so now we need to fill up the graphmap


        for (int i = 0; i < edges.length; i++) {

                graphmap.get(edges[i][0]).add(edges[i][1]);
                graphmap.get(edges[i][1]).add(edges[i][0]);

        }

        //after that now we need to travarse the graph using dfs
//        System.out.println(graphmap);


        return dfs(0,-1) && visitset.size() == n;



    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());


            int[][] edges = new int[row][col];

            for (int i = 0; i < edges.length ; i++) {
                edges[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(validTree(n,edges));
//            System.out.println(visitset.size());
//            System.out.println(visitset);
//            System.out.println(graphmap);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
