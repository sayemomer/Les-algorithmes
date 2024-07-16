package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class merge_intervals {

    public static int[][] merge(int[][] intervals) {


        //first we need to sort the list

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        ArrayList<int[]> merged_intervals = new ArrayList<>();

        int start =0;
        int end =1;

        merged_intervals.add(intervals[0]);

        for (int i = 1; i < intervals.length ; i++) {
            //here we are gonna check if current element of the list is less than the last element of the new list
            // basically we are checking the overlapping
            int[] current_interval = intervals[i];
            int[] last_intervel_of_merged_intervals = merged_intervals.get(merged_intervals.size() -1);
            if(current_interval[start] <= last_intervel_of_merged_intervals[end]){

                merged_intervals.set(merged_intervals.size() -1 ,new int[]{
                        last_intervel_of_merged_intervals[start],Math.max(last_intervel_of_merged_intervals[end],current_interval[end])
                });

            }else {
                merged_intervals.add(intervals[i]);
            }
        }

        return merged_intervals.toArray(new int[merged_intervals.size()][2]);

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[][] intervals = new int[4][2];

            for (int i = 0; i < intervals.length; i++) {

                intervals[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

//            System.out.println(merge(intervals));

            intervals = merge(intervals);

            System.out.println("after merging....");

            for (int i = 0; i < intervals.length; i++) {
                for (int j = 0; j < intervals[i].length; j++) {
                    System.out.println(intervals[i][j]);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
