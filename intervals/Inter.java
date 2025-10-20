package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inter {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> interval_result = new ArrayList<>();

        // [ 1,3] ,[6,9]
        // [2,5]
        //-> [1,5] [6,9]

        int i =0;

        //so, first we need to loop through the intervals
        // and check if the new intervers would append benning

        while (i< intervals.length) {

            if(newInterval[0] > intervals[i][1]){
                interval_result.add(intervals[i]);
            } else if (newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                interval_result.add(newInterval);
            }else {
                interval_result.add(intervals[i]);
            }

            i++;
        }

        return interval_result.toArray(new int[interval_result.size()][]);
    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());

            int[][] intervals = new int[row][2];

            for (int i = 0; i < intervals.length; i++) {

                intervals[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            int[] new_intervals = new int[1];

            new_intervals = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] ar = insert(intervals,new_intervals);

            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[i].length; j++) {
                    System.out.println(ar[i][j]);
                }

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
