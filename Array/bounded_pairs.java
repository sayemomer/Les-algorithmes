package Array;

import java.util.Scanner;

public class bounded_pairs {

    public static int[] convertArray(String rArr, int len) {

        int[] x = new int[len];

        String[] spilitString = rArr.trim().split("\\s+");

        for (int i = 0; i < spilitString.length; i++) {
            x[i] = Integer.parseInt(spilitString[i]);
        }

        return x;
    }

    public static int boundedPair(int len, int[] arr, int lowerBound, int upperBound) {

        int counter = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int bound = arr[i] + arr[j];

                if(bound>= lowerBound && bound<=upperBound){
                    counter++;
                }
            }
        }

        System.out.println(counter);

        return counter;

    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            String rSize = scanner.nextLine();
            int cSize = Integer.parseInt(rSize);

            String rArr = scanner.nextLine();
            String rPair = scanner.nextLine();

            int[] cArr = new int[cSize];
            cArr = convertArray(rArr, cSize);

            String[] cPair = rPair.trim().split("\\s+");

            boundedPair(cSize, cArr, Integer.parseInt(cPair[0]), Integer.parseInt(cPair[1]));

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
