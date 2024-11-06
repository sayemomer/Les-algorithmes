package Graph;

import java.util.*;
import java.util.jar.Manifest;

public class min_cost_to_connect_all_points {

    public static int minCostConnectPoints(int[][] points) {

        int result = 0;

        HashMap<Integer, List<int[]>> adj_list_with_cost_to_every_node = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            adj_list_with_cost_to_every_node.put(i, new ArrayList<>());
        }

        for (int i = 0; i < points.length; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i +1 ; j < points.length; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                int abs_distance_from_i_to_j = Math.abs(x1-x2) + Math.abs(y1 - y2);

                adj_list_with_cost_to_every_node.get(i).add( new int[]{abs_distance_from_i_to_j,j} );
                adj_list_with_cost_to_every_node.get(j).add( new int[]{abs_distance_from_i_to_j,i} );

            }

        }

        PriorityQueue<int[]> min_distant_heap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        min_distant_heap.offer(new int[]{0,0});
        Set<Integer> visit_set = new HashSet<>();

        while (visit_set.size() < points.length){
            int[] curr_min = min_distant_heap.poll();
            int curr_min_dist = curr_min[0];
            int curr_node = curr_min[1];

            if(!visit_set.contains(curr_node)){
                visit_set.add(curr_node);
                result+= curr_min_dist;

                for ( int[] curr : adj_list_with_cost_to_every_node.get(curr_node)) {

                    int curr_neighbour_node = curr[1];

                    if(!visit_set.contains(curr_neighbour_node)){
                        min_distant_heap.offer(curr);
                    }

                }

            }


        }


        return result;

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());
            
            int[][] coordinates = new int[n][2];

            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(minCostConnectPoints(coordinates));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
