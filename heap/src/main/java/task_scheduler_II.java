import java.util.*;

public class task_scheduler_II {

//    AAABBB
//2
//
//    ACABDB
//1
//
//    AAABBB
//3

    public static long taskScheduler(int[] tasks, int space) {

        // HashMap to track the last execution time of each task
        HashMap<Integer, Long> lastExecutionTime = new HashMap<>();
        long currentTime = 0;

        // Iterate through the tasks in order
        for (int task : tasks) {
            currentTime++;
            // Check if the task is still in cooldown
            if (lastExecutionTime.containsKey(task)) {
                long nextAvailableTime = lastExecutionTime.get(task) + space + 1;
                if (currentTime < nextAvailableTime) {
                    currentTime = nextAvailableTime;
                }
            }
            // Update the last execution time for the task
            lastExecutionTime.put(task, currentTime);
        }

        return currentTime;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] tasks = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = Integer.parseInt(sc.nextLine());

            System.out.println(taskScheduler(tasks,n));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
