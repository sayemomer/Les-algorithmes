package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class top_k_frequent_elements {

    public static int[] topKFrequent(int[] nums, int k) {

        int[] topK = new int[k];

        //ok , at first we have to calculate the number of occarance of unique number , In that case
        // we need a hashmap

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        //now we need the top K elements , basically its the top k ,sorted number in hashmap
        //but , if we use sort this is nlogn, we want better then this
        //so, we want a list of lists to hold numbers with same frequency

        List<List<Integer>> buckets = new ArrayList<>(nums.length +1 );

        for (int i = 0; i < nums.length +1; i++) {

            buckets.add(new ArrayList<>());
            
        }
        

        // now iterate through the hashmap

        countMap.forEach((number,frequency)-> {

        // so, here we want out array to be dynamic
        // I might need to put multiple value like {1,2,3}
        buckets.get(frequency).add(number);

        });

        int index = 0;

        // Start from the end of the buckets (highest frequency)
        for (int freq = buckets.size() - 1; freq >= 0 && index < k; freq--) {
            for (int num : buckets.get(freq)) {
                topK[index++] = num;
                if (index == k) break;
            }
        }

        return topK;
        
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String num_s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());

            String[] num_a = num_s.split(" ");

            int[] nums = new int[num_a.length];

            for (int i = 0; i < num_a.length; i++) {
                nums[i] = Integer.parseInt(num_a[i]);
            }

           int[] topK = topKFrequent(nums,k);

           for (int i = 0; i < topK.length; i++) {
            System.out.println(topK[i]);
           }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
