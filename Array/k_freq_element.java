package Array;

import java.util.*;

public class k_freq_element {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];

        HashMap<Integer,Integer> countMap = new HashMap<>();

        for (int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0) +1 );
        }

        List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);

        for (int i = 0; i < nums.length +1; i++) {
            bucket.add(new ArrayList<>());
        }

        countMap.forEach((number,freq)->{
            bucket.get(freq).add(number);
        });

        System.out.println(bucket);

        return topK;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String[] s_nums = sc.nextLine().split(" ");

            int nums[] = Arrays.stream(s_nums).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(sc.nextLine());

            topKFrequent(nums,k);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
