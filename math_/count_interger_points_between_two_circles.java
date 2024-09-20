package math_;

import java.util.Scanner;

public class count_interger_points_between_two_circles {

    public static void count_points(int x, int y){

        int count =0;

        for (int i = -y; i <= y; i++) {

            for (int j = -y; j <= y ; j++) {

                int distance = i*i + j*j;

                if (x * x <= distance && distance <= y * y) {
                    count++;
                }

            }

        }

        System.out.println(count);

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());

            count_points(x,y);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
