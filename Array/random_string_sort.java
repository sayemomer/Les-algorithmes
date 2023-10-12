package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class random_string_sort {

    public static void main(String[] args) {

        String[] arr = "a4Zb2C".split("");

        ArrayList<String> abc = new ArrayList<>();
        ArrayList<String> num = new ArrayList<>();
        ArrayList<String> cap = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].matches("[a-z]")) {
                abc.add(arr[i]);
            } else if (arr[i].matches("[A-Z]")) {
                cap.add(arr[i]);
            } else if (arr[i].matches("[0-9]")) {
               num.add(arr[i]);
            }
        }

        System.out.println(String.join("", abc) + String.join("", num) + String.join("", cap));
    }
    
}
