package Array;
import java.util.HashMap;

public class TwoSum {

    public static int[] findSum(int[] arr, int n) {
        HashMap<Integer, Integer> ht = new HashMap<>();

        for (int i : arr) {
            if (ht.containsKey(i)) {
                return new int[] { i, n - i };
            } else {
                ht.put(n - i, i);
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 21, 3, 14, 5, 60, 7, 6 };
        int n = 27;

        int[] result = findSum(arr, n);
        if (result[0] != -1) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Pair not found");
        }
    }
}

