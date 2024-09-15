package string;

import java.util.Arrays;
import java.util.Scanner;

public class areAlmostEqual {

    public static boolean isEqualAfterSort(String s1,String s2){
        char[] a = s1.toCharArray();
        Arrays.sort(a);
        char[] b = s2.toCharArray();
        Arrays.sort(b);

        String x = new String(a);
        String y = new String(b);

        if(x.equals(y)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean areAlmostEqual(String s1, String s2) {

        boolean ispossible = true;

        if(s1.equals(s2)){
            return true;
        }

        if(!isEqualAfterSort(s1,s2)){
            return false;
        }

        int treshold_count = 0 ;
        int max_treshold = 2;
        int maxlength = s1.length();

        for (int i = 0; i < maxlength; i++) {

            if(s1.charAt(i) != s2.charAt(i)){
                treshold_count++;
            }

            if(treshold_count > max_treshold){
                ispossible = false;
                break;
            }

        }

        return ispossible;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            System.out.println(areAlmostEqual(s1,s2));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
