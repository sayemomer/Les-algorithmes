package Array;

import java.util.Map;
import java.util.Scanner;

/**
 * This solution with two phase doesn't work"
 */

public class LRCR {

    public static int characterReplacement(String s, int k) {
        int lrcr = 0;

        int fistPointer = 0;
        int secondPointer = 0;

        int max_k=k;

        int last =0;

        int curr = 0;

        while (fistPointer < s.length() && secondPointer < s.length()){

            if(s.charAt(fistPointer) == s.charAt(secondPointer)){
                curr = curr +1;
                lrcr = Math.max(lrcr,curr);
                secondPointer++;
                last = secondPointer;
            }else {
                if(max_k > 0){
                    last = secondPointer;
                    curr = curr +1;
                    lrcr = Math.max(lrcr, curr);
                    secondPointer++;
                    max_k--;
                }else {
                    fistPointer = last;
                    secondPointer=last;
                    curr=0;
                    max_k=k;
                }
            }
        }

         fistPointer = s.length() -1;
         secondPointer = s.length() -1;

         curr =0;

        while (fistPointer >=0 && secondPointer >=0 ){

            if(s.charAt(fistPointer) == s.charAt(secondPointer)){
                curr = curr +1;
                lrcr = Math.max(lrcr,curr);
                secondPointer--;
                last = secondPointer;
            }else {
                if(max_k > 0){
                    last = secondPointer;
                    curr = curr +1;
                    lrcr = Math.max(lrcr, curr);
                    secondPointer--;
                    max_k--;
                }else {
                    fistPointer = last;
                    secondPointer=last;
                    curr=0;
                    max_k=k;
                }
            }
        }


        return lrcr;
    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());

            System.out.println(characterReplacement(s,k));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
