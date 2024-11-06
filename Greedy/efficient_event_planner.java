package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class efficient_event_planner {

    public static int max_event(int[][] schedule){

        if(schedule.length <= 1 ){
            return schedule.length;
        }

        Arrays.sort(schedule,(a,b) -> Integer.compare(a[1], b[1]));

        int result =1;

        int init_start = schedule[0][0];
        int init_end = schedule[0][1];

        for (int i = 1; i < schedule.length; i++) {

            int curr_start = schedule[i][0];
            int curr_end = schedule[i][1];

            if(curr_start >= init_end){
                result++;
                init_start = curr_start;
                init_end = curr_end;
            }

        }


        return result;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());

            int[][] schedule = new int[n][2];

            for (int i = 0; i < n; i++) {

                schedule[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(max_event(schedule));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
