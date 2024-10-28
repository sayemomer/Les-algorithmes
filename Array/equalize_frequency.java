package Array;

import java.util.*;

public class equalize_frequency {

    public static boolean equalFrequency(String word) {

        if (word.trim().isEmpty()) {
            return false;
        }

        HashMap<Character, Integer> countWord = new HashMap<>();
        for (char w : word.toCharArray()) {
            countWord.put(w, countWord.getOrDefault(w, 0) + 1);
        }

        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        for (int freq : countWord.values()) {
            frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
        }


        if (frequencyCount.size() == 1) {

            return frequencyCount.containsKey(1) || frequencyCount.values().iterator().next() == 1;
        }

        if (frequencyCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(frequencyCount.keySet());
            int freq1 = keys.get(0);
            int freq2 = keys.get(1);


            if ((freq1 == 1 && frequencyCount.get(freq1) == 1) || (freq2 == 1 && frequencyCount.get(freq2) == 1)) {
                return true;
            }

            if (Math.abs(freq1 - freq2) == 1) {
                if ((freq1 > freq2 && frequencyCount.get(freq1) == 1) || (freq2 > freq1 && frequencyCount.get(freq2) == 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();

            System.out.println(equalFrequency(s));

        }catch (Exception e){
            e.printStackTrace();
        }
//        runTestCase();
    }

    public static void runTestCase() {
        testCase("abcc", true, 1);
        testCase("aazz", false, 2);
        testCase(" ", false, 3);
        testCase("ab", true, 4);
        testCase("abc", true, 5);
        testCase("abbcc", true, 6);
    }

    public static void testCase(String s, boolean expected, int test) {
        boolean result = equalFrequency(s);

        if (result == expected) {
            System.out.println(test + " Passed");
        } else {
            System.out.println(test + " --Failed--");
        }
    }
}
