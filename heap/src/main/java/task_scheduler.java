import java.net.Inet4Address;
import java.util.*;

public class task_scheduler {

    public static int leastInterval(char[] tasks, int n) {
        int min_num_of_interval = 0;

        // Count the frequency of each task
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        // Create a max-heap based on task frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int freq : countMap.values()) {
            maxHeap.offer(freq);
        }

        // Queue to track tasks on cooldown
        Queue<int[]> available = new LinkedList<>();

        while (!maxHeap.isEmpty() || !available.isEmpty()) {
            min_num_of_interval++;

            // Process task from maxHeap
            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll() - 1;
                if (curr > 0) {
                    available.add(new int[]{curr, min_num_of_interval + n});
                }
            }

            // Re-add tasks from cooldown queue back to maxHeap
            if (!available.isEmpty() && available.peek()[1] == min_num_of_interval) {
                maxHeap.offer(available.poll()[0]);
            }
        }

        return min_num_of_interval;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            char[] tasks = sc.nextLine().toCharArray();
            int n = Integer.parseInt(sc.nextLine());

            System.out.println(leastInterval(tasks,n));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
