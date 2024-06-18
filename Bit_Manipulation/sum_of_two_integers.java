package Bit_Manipulation;

import java.util.Scanner;

public class sum_of_two_integers {

    public static int getSum(int a, int b) {

        while (b!=0){
            int temp = (a&b)<<1;
            a = a^b;
            b = temp;

        }

        return a;

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());

            System.out.println(getSum(a,b));

        }
    }
}
