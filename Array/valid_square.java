package Array; 

import java.util.HashMap;
import java.util.Scanner;

public class valid_square {


    public static boolean checkSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        //check that the co-ordinates are distict or not

        if(p1[0] == p2[0] && p1[1] == p2[1] || p1[0] == p3[0] && p1[1] == p3[1] || p1[0] == p4[0] && p1[1] == p4[1] || p2[0] == p3[0] && p2[1] == p3[1] || p2[0] == p4[0] && p2[1] == p4[1] || p3[0] == p4[0] && p3[1] == p4[1]){
            return false;
        }


            //p1 , p2
            double x1x2 = Math.sqrt(Math.pow( p2[0] - p1[0], 2) + Math.pow( p2[1] - p1[1], 2));
            //p1 , p3
            double x1x3 = Math.sqrt(Math.pow( p3[0] - p1[0], 2) + Math.pow( p3[1] - p1[1], 2));
            //p1 , p4
            double x1x4 = Math.sqrt(Math.pow( p4[0] - p1[0], 2) + Math.pow( p4[1] - p1[1], 2));
            //p2 , p3
            double x2x3 = Math.sqrt(Math.pow( p3[0] - p2[0], 2) + Math.pow( p3[1] - p2[1], 2));
            //p2 , p4
            double x2x4 = Math.sqrt(Math.pow( p4[0] - p2[0], 2) + Math.pow( p4[1] - p2[1], 2));
            //p3 , p4
            double x3x4 = Math.sqrt(Math.pow( p4[0] - p3[0], 2) + Math.pow( p4[1] - p3[1], 2));


            double[] arr = {x1x2, x1x3, x1x4, x2x3, x2x4, x3x4};
            
            //now check if two distance is same as diaognal and four same as sides

            HashMap<Double, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                if(map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
                
            }

            if(map.size()== 2){
                return true;
            }else{
                return false;
            }
        
    }

public static void main(String[] args) {

    int[ ] p1 = {0,0};
    int[ ] p2 = {1,1};
    int[ ] p3 = {-1,0};
    int[ ] p4 = {1,0};

   System.out.println(checkSquare(p1, p2, p3, p4)); 
}


    }
