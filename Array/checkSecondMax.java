package Array;

import java.util.Arrays;

public class checkSecondMax {

    public static int findMaximum(int[] arr) {

        // first lets assume max number is in the first index
        int max = arr[0];
        int index = 0;

        // then loop through the array and update the max number if exits

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        return index;
    }

    public static int findSecondMaximum(int[] arr) {
        // Write - Your - Code
        // first lets get the first max
        int max = findMaximum(arr);

        // then remove the first max number from the array

        int[] anotherArray = new int[arr.length - 1];
        System.arraycopy(arr, 0, anotherArray, 0, max);

        System.arraycopy(arr, max + 1,
                anotherArray, max,
                arr.length - max - 1);

        int secondMax = findMaximum(anotherArray);

        System.out.println(Arrays.toString(anotherArray));

        return anotherArray[secondMax];
    }

    public static void main(String[] args) {

        int arr[] = { 9, 2, 3, 6 };

        System.out.println(findSecondMaximum(arr));

    }

}
