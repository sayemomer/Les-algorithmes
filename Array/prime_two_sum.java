package Array;

import java.util.HashMap;

class prime_two_sum {

    public static boolean isPrime(int val) {

        if (val <= 1) {
            return false;
        }

        for (int i = 1; i < val; i++) {
            if (val % 2 == 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 5, 11, 3, 17, 13, 19 };
        int target = 12;
        HashMap<Integer, int[]> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (hm.containsKey(arr[i])) {

                if (isPrime(arr[i]) && isPrime(target - arr[i])) {

                    System.out.println("Two consecutive prime numbers with a sum of " +
                            target + " are " + arr[i] + " and " + (target - arr[i]) + " found at indices " + i + " and "
                            + hm.get(arr[i])[1] + " respectively");
                    break;
                }

            } else {

                hm.put(target - arr[i], new int[] { arr[i], i });
            }

        }
    }
}