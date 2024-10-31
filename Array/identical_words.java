package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class identical_words {

    public static String find_min(String[][] grid){
        StringBuilder result = new StringBuilder();
        int maxchange = 0;

        for (int i = 0; i < grid[0].length; i++) {
            HashMap<String,Integer> count_freq = new HashMap<>();
            int max_freq = Integer.MIN_VALUE;
            String s ="";
            for (int j = 0; j < grid.length; j++) {

                count_freq.put(grid[j][i],count_freq.getOrDefault(grid[j][i],0)+1);
//                System.out.println(count_freq);
            }

            for (Map.Entry<String,Integer> entry : count_freq.entrySet()){
                if( entry.getValue() > max_freq){
                    max_freq = entry.getValue();
                    s = entry.getKey();
                }
            }

            result.append(s);
            maxchange += grid.length - max_freq;

        }

        result.append("\n").append(maxchange);

        return  result.toString();
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int[] r_c = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String[][] grid = new String[r_c[0]][r_c[1]];

            for (int i = 0; i < grid.length; i++) {
                grid[i] = sc.nextLine().split("");
            }

            System.out.println(find_min(grid));

        }catch (Exception e){
                e.printStackTrace();
        }

//        runTestCases();

    }

    public static void runTestCases(){
        testCases(new String[][] {{"a","b","c","e","d","b","d","e"},
                {"b","d","b","d","e","b","a","a"},{"c","d","b","a","b","d","e","c"},{"a","b","e","d","b","c","a","d"},
                {"c","d","d","e","a","e","b","c"}},"adbdbbac\n23");
    }

    public static void testCases(String[][] grid,String expected){
        String result = find_min(grid);
        System.out.println(result);

        if(result.equals(expected)){
            System.out.println("passed");
        }else {
            System.out.println("--failed--");
        }

    }
}
