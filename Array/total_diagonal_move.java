package Array;

import java.util.HashMap;
import java.util.Scanner;

public class total_diagonal_move {
    public static void main(String[] args) {
        // take user input
        // The first line represents N.
        // The second line represents the starting location.
        // The third line represents the destination location
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            String start = sc.nextLine();
            String end = sc.nextLine();

            HashMap<String, Integer> firstDiagonal = new HashMap<>();
            HashMap<String, Integer> secondDiagonal = new HashMap<>();
            

            int x = 65;
            int y = n - 1;

            for (int i = 0; i < n; i++) {
                String letter = Character.toString(x);
                firstDiagonal.put(letter + i, i);
                secondDiagonal.put(letter + y, i);
                x++;
                y--;
            }

            // for (int i = 0; i < grid.length; i++) {
            //     for (int j = 0; j < grid.length; j++) {
            //         String letter = Character.toString(x);
            //         grid[i][j] = letter + i;
            //         x++;
            //     }
            //     x = 65;
            // }

            //print the grid
            // for (int i = 0; i < grid.length; i++) {
            //     System.out.println();
            //     for (int j = 0; j < grid.length; j++) {
            //         System.out.print(grid[i][j] + " ");
            //     }
            // }

            if(( (firstDiagonal.containsKey(start) && firstDiagonal.containsKey(end))
             || (secondDiagonal.containsKey(start) && secondDiagonal.containsKey(end)) ) && 
             start.equals(end)){
                System.out.println(1);
                return;
            }

            if ( ( firstDiagonal.containsKey(start) || secondDiagonal.containsKey(start) ) && (firstDiagonal.containsKey(end)
                    || secondDiagonal.containsKey(end) ) ) {
                if ( (firstDiagonal.containsKey(start) && firstDiagonal.containsKey(end)) || (secondDiagonal.containsKey(start) && secondDiagonal.containsKey(end)) ) {
                    System.out.println(1);
                    return;
                }else{
                    System.out.println(2);
                    return;
                }
                // if (firstDiagonal.containsKey(start) && secondDiagonal.containsKey(end)) {
                //     System.out.println(2);
                //     return;
                // }
                // if (firstDiagonal.containsKey(end) && secondDiagonal.containsKey(start)) {
                //     System.out.println(2);
                //     return;
                // }
            } else {
                System.out.println(-1);
                return;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
