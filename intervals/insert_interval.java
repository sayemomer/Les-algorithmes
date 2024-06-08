package intervals;

import java.util.ArrayList;
import java.util.Scanner;

public class insert_interval {

    public  static int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> intervals_result = new ArrayList<>();
        int i =0;

        //so, first we need to loop through the intervals
        // and check if the new intervers would append benning

        while (i< intervals.length && newInterval[0] > intervals[i][1]) {
            intervals_result.add(intervals[i]);
            i++; 
        }

        // now check the merge

        while (i< intervals.length && newInterval[1] >= intervals[i][0] ) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
            
        }
        intervals_result.add(newInterval);

        //add the remaining

    
        // Add all intervals after the new interval
        while (i < intervals.length) {
            intervals_result.add(intervals[i]);
            i++;
        }

        return intervals_result.toArray(new int[intervals_result.size()][]);
        
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());

            int[][] intervals = new int[row][2];

            for (int i = 0; i < intervals.length; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < intervals[0].length; j++) {
                    intervals[i][j] = Integer.parseInt(s[j]);
                }
            }

            int[] new_intervals = new int[2];

            String[] new_s = sc.nextLine().split(" ");

            new_intervals[0] = Integer.parseInt(new_s[0]);
            new_intervals[1] = Integer.parseInt(new_s[1]);

            intervals =insert(intervals,new_intervals);


            System.out.println("after insertion");
            
            for (int i = 0; i < intervals.length; i++) {
                String x = "";
                for (int j = 0; j < intervals[0].length; j++) {
                    x = x + intervals[i][j] + " ";
                }

                System.out.println(x);
                
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

//test case


// 2
// 1 3
// 6 9
// 2 5
