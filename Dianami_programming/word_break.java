package Dianami_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class word_break {

//    s = "leetcode" ,
//    wordDict = ["leet","code"]

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length()-1 ; i >= 0; i--) {

            for (int j = 0; j < wordDict.size(); j++) {

                //first we need to check the bound ,
                if( (i+wordDict.get(j).length()) <= s.length() && s.substring(i,i+wordDict.get(j).length()).equals(wordDict.get(j))){
                    dp[i] = dp[i + wordDict.get(j).length()];
                }
                if (dp[i]){
                    break;
                }


            }

        }

        return dp[0];
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();
            String[] wordDict = sc.nextLine().split(" ");

            List<String> wordDictStr = new ArrayList<>();

            for (int i = 0; i < wordDict.length; i++) {
                wordDictStr.add(wordDict[i]);
            }

            System.out.println(wordBreak(s,wordDictStr));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
