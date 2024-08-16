package intervals;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class eraseOverlapIntervals {


    public static int solution(int[][] intervals) {

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));


        for (int[] a :intervals){
            System.out.println(a[0]);
            System.out.println(a[1]);
        }

        int nums_of_eraseOverlapIntervals = 0;

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {

                nums_of_eraseOverlapIntervals++;
            }else {
                start = intervals[i][0];
                end = intervals[i][1];
            }

        }

        return nums_of_eraseOverlapIntervals;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            int[][] intervals = new int[row][col];

            for (int i = 0; i < intervals.length; i++) {
                intervals[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(solution(intervals));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
