package intervals;

import java.util.*;

public class meeting_schedule_II {


    public static int minMeetingRooms(List<Interval> intervals) {

        //firstly we need two list , one start list , another end list

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {

            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;

        }

        Arrays.sort(start);
        Arrays.sort(end);

        int result=0;
        int count=0;

        int start_pointer =0;
        int end_pointer =0;

        while (start_pointer < start.length){

            if(start[start_pointer] < end[end_pointer]){
                count++;
                start_pointer++;
            } else {
                count--;
                end_pointer++;
            }

            result = Math.max(result,count);
        }

        return result;

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){

            int row = Integer.parseInt(sc.nextLine());
            List<Interval> meeting_times = new ArrayList<>();

            for (int i = 0; i < row; i++) {

                String[] s = sc.nextLine().split(" ");

                meeting_times.add(new Interval(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
                
            }

            System.out.println(minMeetingRooms(meeting_times));



        }catch (Exception e){
            System.out.println();
        }

    }
}
