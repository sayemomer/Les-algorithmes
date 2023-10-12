package Array;

import java.util.Arrays;
import java.util.Scanner;

public class pair_sum {


    public static void pairSum(int[] arr, int len){

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i%2 == 0){
                max+=arr[i];
            }
            
        }

        System.out.println("max_sum: " + max);

    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

        int len = Integer.parseInt(sc.nextLine());

        String arr = sc.nextLine();

        String[] rArr = arr.split(" ");

        int[] cArr = new int[rArr.length];

        for (int i = 0; i < rArr.length; i++) {
            cArr[i] = Integer.parseInt(rArr[i]);
        }

        pairSum(cArr, len);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
