package Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longest_consecutive_sequence {


    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longest_sequence = 0;

        for(int num : nums){

            int left_number = num - 1;

            // if the leftNumber contains in the list then this is the first number
            // of the sequence, we need to check that in the set

            if(!numSet.contains(left_number)){
                // if this doesn't exist in the set , so this is the first number
                // now lets search for the consecutive rest of hte number

                int length = 1;

                int right_number = num + 1;

                while (numSet.contains(right_number)) {
                    right_number ++;
                    length ++;
                }

                if(length > longest_sequence){
                    longest_sequence = length;
                }

            }
        }

        return longest_sequence;
        
    }


    public static void main(String[] args) {


        try (Scanner sc = new Scanner(System.in)){

            String str = sc.nextLine();

            String[] arr_str = str.split(" ");

            int[] arr = new int[arr_str.length];

            for (int i = 0; i < arr_str.length; i++) {
                arr[i] = Integer.parseInt(arr_str[i]);
            }
        
            longest_consecutive_sequence obj = new longest_consecutive_sequence();
            System.out.println(obj.longestConsecutive(arr));
            
        } catch (Exception e) {
            // TODO: handle exception
        }


        
    }
    
}
