package Dianami_programming;

import java.util.Scanner;

public class climbing_stairs {

    public static int climbStairs(int n) {

        int one =1;
        int two =1;

        for (int i = 0; i < n-1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int number_of_steps = Integer.parseInt(sc.nextLine());

            System.out.println(climbStairs(number_of_steps));

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
