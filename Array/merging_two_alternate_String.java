package Array;

import java.util.Scanner;

public class merging_two_alternate_String {

    public static StringBuilder concat(String[] s1,String[] s2){
        int first =0;
        int second = 0;

        StringBuilder result = new StringBuilder();

        while (first < s1.length && second < s2.length){

            result.append(s1[first]);
            result.append(s2[second]);

            first++;
            second++;
        }

        while (first < s1.length){
            result.append(s1[first]);
            first++;
        }
        while (second < s2.length){
            result.append(s2[second]);
            second++;
        }

        return result;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            String[] s1 = sc.nextLine().split("");
            String[] s2 = sc.nextLine().split("");

            System.out.println(concat(s1,s2));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
