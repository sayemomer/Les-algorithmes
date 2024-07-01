package Sorting;

import java.util.*;

public class most_frequent_even_element {

    public static int mostFrequentEven(int[] nums) {

        //ok first I need result obviously
        int result = -1;

        //next I need a counter to count all even number of occurance
        // for that I need a hashmap

        HashMap<Integer,Integer> count_even = new HashMap<>();

        for (int num:
                nums) {
            if( num%2 ==0){
                count_even.put(num ,count_even.getOrDefault(num,0)+1);
            }
        }

        // now we need a arralist to store the top elements in places

        List<List<Integer>> bucket_sort_list = new ArrayList<>();

        //now we need new list here

        for (int i = 0; i < nums.length + 1; i++) {
            bucket_sort_list.add(new ArrayList<>());
        }

        count_even.forEach((num,frequency)-> bucket_sort_list.get(frequency).add(num));

        System.out.println(bucket_sort_list);

        for (int i = bucket_sort_list.size() -1 ; i >= 0; i--) {

            List<Integer> curr = bucket_sort_list.get(i);

            if(!curr.isEmpty()){
                if(curr.size() > 1){
                    result = Collections.min(curr);
                    break;
                }else {
                    result = curr.get(0);
                    break;
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(mostFrequentEven(nums));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
