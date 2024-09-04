package OOP;

/*
this potion contains the java libraries that you shound drink
en francais tu doit !
 */

import java.util.Arrays;
import java.util.Scanner;

public class redpill_java {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            //1-> To convert a string input into int in one line using java stream
            int[] string_to_int_array  = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //2-> to convert a 2D array like this
            int[][] string_to_int_array_2D = new int[2][2];
            for (int i = 0; i < string_to_int_array_2D.length; i++) {
                string_to_int_array_2D[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
