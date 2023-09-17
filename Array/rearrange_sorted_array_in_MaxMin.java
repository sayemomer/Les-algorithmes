package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class rearrange_sorted_array_in_MaxMin {

  public static void maxMin(int[] arr) {

    // Write - Your - Code
    ArrayList<Integer> result = new ArrayList<Integer>();

    int min = 0;
    int max = arr.length - 1;

    int mid = (arr.length - 1) / 2;

    int[] minList = Arrays.copyOfRange(arr, min, mid);
    int[] maxList = Arrays.copyOfRange(arr, mid, arr.length);

    System.out.println(Arrays.toString(minList));
    System.out.println(Arrays.toString(maxList));

  }

  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

    maxMin(arr);
  }

}
