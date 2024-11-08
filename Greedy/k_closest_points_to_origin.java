package Greedy;

import java.util.*;

public interface k_closest_points_to_origin {

    public static int[][] kClosest(int[][] points, int k) {
        int[][] k_closest = new int[k][2];

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        for (int[] point : points){

            int dis = (int) (Math.pow( (point[0] - 0 ) , 2) + Math.pow( point[1] - 0 ,2));
            min_heap.offer(new int[]{dis,point[0],point[1]});

        }

        for (int i = 0; i < k; i++) {

            int[] curr = min_heap.poll();

            k_closest[i] = new  int[]{curr[1],curr[2]};

        }

        return  k_closest;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());
            int[][] coordinates = new int[n][2];

            for (int i = 0; i < n; i++) {
                coordinates[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int k = Integer.parseInt(sc.nextLine());

            int[][] x = kClosest(coordinates,k);

            for (int i = 0; i < x.length; i++) {

                System.out.println(x[i][0]  +"" + x[i][1]);

            }

            System.out.println(kClosest(coordinates,k));

//            System.out.println(Arrays.toString(kClosest(coordinates,k)));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
