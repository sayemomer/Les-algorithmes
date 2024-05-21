package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


public class longest_repeating_character_replacement {


    public static int characterReplacement(String s, int k) {

        //AABABBA

        //l=2
        //r=4

        //BABB

        int left_pointer =0;
        int max_length =0;

        Map<Character,Integer> sum_container = new HashMap<>();


        for(int right_pointer = 0 ; right_pointer< s.length() ; right_pointer++){

                char right_chareter = s.charAt(right_pointer);

                sum_container.put(right_chareter,sum_container.getOrDefault(right_chareter, 0)+ 1);

                //firstly we have to get the Char with maximum number

                Optional<Integer> maxValue = sum_container.values().stream().max(Integer::compare);

                // from here we calculate the length of the window substruct it with the max number of the container
                //if its less than or equal to the k this window is valid, and we update the maxlength

                int window_length = right_pointer - left_pointer + 1;
                int check_valid_window = window_length - maxValue.get();
                
                if(check_valid_window > k){
                    //if its invalid we need to update the left pointer untill the window is valid
                    //and also we need to update the container

                        char left_chareter = s.charAt(left_pointer);

                        //update the container
                        sum_container.replace(left_chareter , sum_container.get(left_chareter) -1 );
                        //update the pointer
                        left_pointer++;

                }

                max_length = Math.max(max_length, right_pointer - left_pointer + 1);


            }

        return max_length;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());

            System.out.println(characterReplacement(s, k));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
