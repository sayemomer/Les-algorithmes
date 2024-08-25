package Dianami_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class decode_ways {

    public static int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp,1);

        Set<Character> setof = new HashSet<>(Set.of('0','1','2','3','4','5','6'));

        for (int i = s.length() -1 ; i >=0 ; i--) {


            if(s.charAt(i) == '0'){
                dp[i] =0;
            }else {
                dp[i] = dp[i+1];
            }

            if(i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && setof.contains(s.charAt(i+1)) )){
                dp[i] += dp[i+2];
            }

        }

        return dp[0];
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();

            System.out.println(numDecodings(s));

        }catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
