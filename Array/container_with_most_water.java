package Array;

import java.util.Scanner;

public class container_with_most_water {


    public static int maxArea_pro(int[] height){

                //lets first write a two pointer while loop

                int maxArea = 0;
                int first_pointer = 0;
                int second_pointer = height.length - 1;
        
                while (first_pointer < second_pointer) {
        
                    //now we need to calculate the area of this two point
                    //first the height
                    //height if the height of both index is same we take the first one
                    //otherwise we take the minimum
        
                    int container_height =0;
                    int container_width =0;
                    int area = Math.min(height[first_pointer], height[second_pointer]) *  (second_pointer - first_pointer);
    
        
                    // now we have to set rule to update the max area
        
                    maxArea = Math.max(maxArea, area);
                    
        
                    //lastly we need condition to change the pointers
                    // if both of the height are same we change the second index
                    // otherwise the min index
        
                    if( height[first_pointer] >= height[second_pointer]){
                        second_pointer --;
                    }else{
                        first_pointer ++;
                    }
        
                }
        
                return maxArea;

    }


    public static int maxArea(int[] height) {

        //lets first write a two pointer while loop

        int maxArea = 0;
        int first_pointer = 0;
        int second_pointer = height.length - 1;

        while (first_pointer <= second_pointer) {

            //now we need to calculate the area of this two point
            //first the height
            //height if the height of both index is same we take the first one
            //otherwise we take the minimum

            int container_height =0;
            int container_width =0;
            int area =0;

            if (height[first_pointer] == height[second_pointer]) {
                container_height = height[first_pointer];
            }else{
                container_height = Math.min(height[first_pointer], height[second_pointer]);
            }

            //so now the width, width is the distance between the two pointer
            // its the distance between the two index

            container_width = (second_pointer - first_pointer) ;

            //so the area is:
            area = container_height * container_width;

            // now we have to set rule to update the max area

            if(area > maxArea){
                maxArea = area;
            }

            //lastly we need condition to change the pointers
            // if both of the height are same we change the second index
            // otherwise the min index

            if( height[first_pointer] >= height[second_pointer]){
                second_pointer --;
            }else{
                first_pointer ++;
            }

        }

        return maxArea;
        
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String nums_s = sc.nextLine();
            String[] nums_a = nums_s.split(" ");
            int[] nums = new int[nums_a.length];

            for (int i = 0; i < nums_a.length; i++) {

                nums[i] = Integer.parseInt(nums_a[i]);
                
            }

            System.out.println(maxArea(nums));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
