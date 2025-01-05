import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class car_pooling {

    public static boolean carPooling(int[][] trips, int capacity) {

        // [passenger,start,end]
        Arrays.sort(trips,(a,b)-> Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> trips_that_ends_first = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int total_passanger = 0;

//        System.out.println(Arrays.toString(trips[0]) );
//        System.out.println(Arrays.toString(trips[1]) );
//        System.out.println(Arrays.toString(trips[2]) );

        for (int i = 0; i < trips.length; i++) {
            //for each trips we need to the capacity

            int curr_pass = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            //this is the subproblem that we need to solve
            //what if we can drop the passenger in a destination
            while (!trips_that_ends_first.isEmpty() && trips_that_ends_first.peek()[0] <= start){
                //drop off the passenger
                total_passanger -= trips_that_ends_first.poll()[1];

            }

            //add the current passenger
            total_passanger += curr_pass;

            System.out.println(total_passanger);

            if(total_passanger > capacity){
                return false;
            }

            trips_that_ends_first.offer(new int[] { end, curr_pass });

        }



        return true;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int[][] trips = new int[row][3];

            for (int i = 0; i < trips.length; i++) {

                trips[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int capacity = Integer.parseInt(sc.nextLine());

            System.out.println(carPooling(trips,capacity));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
