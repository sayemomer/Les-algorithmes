package Greedy;

import java.util.Scanner;

public class jump_game {

    public static boolean canJump(int[] nums) {

        //2 3 1 1 4
        //3 2 1 0 4


        //first we need to keep track of the maximum jump we can make
        int max_jump = 0;


        for (int i = 0; i < nums.length; i++) {
            
            if(i>max_jump){
                return false;
            }else{
                max_jump = Math.max(max_jump, i + nums[i]);
            }
            
        }

        return true;
        
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] s = sc.nextLine().split(" ");

            int[] nums = new int[s.length];

            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            System.out.println(canJump(nums));


            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
