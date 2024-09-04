package Graph;

import java.util.*;

public class clone_graph {

    public static Node dfs(Node node,HashMap<Node,Node> visitset){

        // here we need that check
        // if the node exits in our visitset we return the new_reference

        if(visitset.containsKey(node)){
            return visitset.get(node);
        }

        // so if not we need to create a copy of this node

        Node copy = new Node(node.val);
        //add the refence

        visitset.put(node,copy);

        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(dfs(node.neighbors.get(i),visitset));
        }

        return copy;

    }

    public static Node cloneGraph(Node node) {

        //so instead of the full graph here we just have the reference of a single old graph node
        //we need to traverse from that single node to the neighbors
        //so its a dfs problem
        // but this time as a souce of visited node we need to store both the old and new reference
        // coz while adding add_jecency we needd the new refence not the new one
        // philosophically its about to create bonding with old and new you need to save both in some where

        //lets do it , so our dfs function will get the node
        HashMap<Node,Node> old_to_new_ref_aka_visit_set = new HashMap<>();

       return dfs(node,old_to_new_ref_aka_visit_set);

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            //4 2

//            2 4
//            1 3
//            2 4
//            1 3

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] add_list = new int[row][col];

            for (int i = 0; i < add_list.length; i++) {

                add_list[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            //I think here it would be better to store it in a dictionary

            //lets create a dictionary
            HashMap<Integer,Node> graphmap = new HashMap<>();

            for (int i = 1; i <= row; i++) {

                Node node = new Node(i);

                graphmap.put(i,node);

            }

            //next we need to fill up this graphmap

            for (int i = 0; i < add_list.length; i++) {

                Node node1 = graphmap.get(add_list[i][0]);
                Node node2 = graphmap.get(add_list[i][1]);

                node1.neighbors.add(node2);
                node2.neighbors.add(node1);
            }

            // so here I got the add_list hashmap
            //but its not final yet coz the function just takes a single node as source
            // so we need to fill that code

            System.out.println(cloneGraph(graphmap.get(1)));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
