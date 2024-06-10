package intervals;

import java.util.*;

public class meeting_schedule {

    public static boolean canAttendMeetings(List<Interval> intervals) {

        //if its not sorted we need to sort

        // Sort intervals based on their start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });


        boolean canAttendMeetings = true;

        if(intervals.size() <=0){

            return canAttendMeetings;
        }

        Interval prev_meeting = new Interval(0,0);

        for (Interval e:
             intervals) {

            if(e.start < prev_meeting.end){
                canAttendMeetings = false;
                break;
            }
            prev_meeting = e;

        }



        return canAttendMeetings;

    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int row =Integer.parseInt(sc.nextLine());
            List<Interval> meeting_times = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                String[] times = sc.nextLine().split(" ");

                meeting_times.add(new Interval(Integer.parseInt(times[0]) ,Integer.parseInt(times[1])));

            }

            System.out.println(canAttendMeetings(meeting_times));



        }catch (Exception e){

            System.out.println();

        }

    }
}
