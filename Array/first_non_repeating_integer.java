package Array;

import java.util.HashMap;

public class first_non_repeating_integer {
    public static int findFirstUnique(int[] arr) {
        // create a hash table
        // iterate through the array
        // if the element is not in the hash table, add it
        // if the element is in the hash table, remove it
        // return the first element in the hash table
        int result = 0;
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for(int i=0 ; i< arr.length;i++){
            if(map.get(arr[i]) == 1){
                result = arr[i];
                break;
            }
        }

        // if no unique element found, return -1 , otherwise return the first unique
        // element
        return result > 0 ? result : -1;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 2, 3, 2, 6, 6 };
        System.out.println(findFirstUnique(arr));

        int[] arr2 = { 4, 4, 1, 1, 0, 0 };
        System.out.println(findFirstUnique(arr2));
    }

}
