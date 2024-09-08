package Array;

import java.lang.reflect.Array;
import java.util.*;

public class array_pair_sum {

    public static int dfs(int[] nums,int min_sum){

        //we need a base case when it hits bottom

        if(nums.length == 0){
            return min_sum;
        }

        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length ; j++) {

                //now we take min from this two as this min(a1,b2)
                int curr_min = Math.min(nums[i],nums[j]);
                //now call recursive for rest of the nums

                int[] rest_nums = new int[nums.length -2];
                int idx =0;

                for (int k = 0; k< nums.length; k++) {

                    if(k!=i && k!=j){
                        rest_nums[idx] = nums[k];
                        idx++;
                    }

                }

                max_sum = Math.max(max_sum,dfs(rest_nums,curr_min + min_sum));

            }

        }

        return max_sum;

    }

    public static int maxpairsum_bf(int len, int[] nums){

        return dfs(nums,0);

    }

    public static int maxpairsum(int len, int[] nums){

        int max_sum = Integer.MIN_VALUE;
        int min_sum = 0;

        //in this solution we are gonna sort the nums

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i=i+2) {
            int curr_min = Math.min(nums[i],nums[i+1]);
            min_sum = min_sum+curr_min;
            max_sum = Math.max(max_sum,min_sum);
        }

        return max_sum;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int len = Integer.parseInt(sc.nextLine());
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//            System.out.println(maxpairsum_bf(len,nums));
            System.out.println(maxpairsum(len,nums));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
