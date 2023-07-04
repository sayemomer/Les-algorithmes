package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class merge_two_sorted_list {

    //merge two sorted array in place
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        return nums1;
    }

    // merge arr1 and arr2 into a new result array
    public static ArrayList<Integer> mergeArrays(int[] arr1, int[] arr2) {
        // write your code here

        int firtstPointer = 0;
        int secondPointer = 0;

        ArrayList<Integer> sortedMergedArray = new ArrayList<>();

        while (firtstPointer < arr1.length && secondPointer < arr2.length) {

            if (arr1[firtstPointer] < arr2[secondPointer]) {
                sortedMergedArray.add(arr1[firtstPointer]);
                firtstPointer++;
            } else {
                sortedMergedArray.add(arr2[secondPointer]);
                secondPointer++;
            }

        }

        if (firtstPointer < arr1.length) {

            for (Integer integer : Arrays.copyOfRange(arr1, firtstPointer, arr1.length)) {
                sortedMergedArray.add(integer);
            }
        }

        if (secondPointer < arr2.length) {
            for (Integer integer : Arrays.copyOfRange(arr2, secondPointer, arr2.length)) {
                sortedMergedArray.add(integer);
            }

        }
        return sortedMergedArray; // make a new resultant array and return your results in that
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 3, 4, 5 , 0, 0, 0, 0};
        int[] arr2 = { 2, 6, 7, 8 };

        // System.out.println(mergeArrays(arr1, arr2));

        int[] mergedArray = merge(arr1, 4, arr2, 4);

        for (int i : mergedArray) {
            System.out.print(i + " ");
        }

 
    }

}
