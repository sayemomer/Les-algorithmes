package Dianami_programming;

import java.util.Arrays;
import java.util.Scanner;

public class unique_paths {

    public static int uniquePaths(int m, int n) {

        int[] result_row = new int[n];

        Arrays.fill(result_row,1);


        for (int i = m-2; i >= 0 ; i--) {
            int[] new_row = new int[n];
            Arrays.fill(new_row,1);
            for (int j = n-2; j >= 0; j--) {
                new_row[j] = new_row[j+1] + result_row[j];
            }

//            System.out.println(new_row[0]);
            result_row = new_row;

        }

        return result_row[0];

    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            System.out.println(uniquePaths(row,col));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
