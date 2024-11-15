package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class find_the_winner_of_circular_game {

    public static int select_winner(int n, int k) {

        if(n <=0 ){
            return 0;
        }
        List<Integer> players = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            players.add(i);
        }

        int index = 0;

        while (players.size() > 1) {

            index = (index + k - 1) % players.size();
            players.remove(index);
        }

        return players.get(0);
    }

    public static void main(String[] args) {
         try(Scanner sc = new Scanner(System.in)){

            int n = Integer.parseInt(sc.nextLine());
            int k = Integer.parseInt(sc.nextLine());

            System.out.println(select_winner(n,k));

        }catch (Exception e){
            e.printStackTrace();
        }
//        runTestCases();
    }

    public static void runTestCases() {
        testcase(5, 2, 3, 1);
        testcase(6, 5, 1, 2);
    }

    public static void testcase(int n, int k, int expected, int test) {
        int result = select_winner(n, k);

        System.out.println("Result: " + result);

        if (result == expected) {
            System.out.println("Test " + test + " passed");
        } else {
            System.out.println("Test " + test + " failed");
        }
    }
}
