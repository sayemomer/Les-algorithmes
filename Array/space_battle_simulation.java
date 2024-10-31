package Array;

import java.util.*;

public class space_battle_simulation {

    public static String final_order(List<Integer> grid){

        StringBuilder result = new StringBuilder();

        if(grid.isEmpty()){
            return "0";
        }

        if(grid.size() == 1){
            return Integer.toString(grid.get(0));
        }

        int left_p = 0;
        int right_p = 1;

        while (left_p >= 0 && right_p < grid.size()){

            int player_x = grid.get(left_p);
            int player_y = grid.get(right_p);

            int player_x_abs = Math.abs(player_x);
            int player_y_abs = Math.abs(player_y);

            // Corrected sign checks
            boolean player_x_is_neg = player_x < 0;
            boolean player_y_is_neg = player_y < 0;

            // Collision only occurs when one is moving right and the other is moving left
            if (player_x > 0 && player_y < 0) {
                // Collision happens

                if (player_x_abs > player_y_abs) {
                    // player_y is destroyed
                    grid.remove(right_p);
                    // No need to increment right_p since the next element has shifted into right_p
                } else if (player_x_abs < player_y_abs) {
                    // player_x is destroyed
                    grid.remove(left_p);
                    // Adjust indices after removal
                    left_p = Math.max(left_p - 1, 0);
                    right_p = left_p + 1;
                } else {
                    // Both are destroyed
                    grid.remove(right_p);
                    grid.remove(left_p);
                    left_p = Math.max(left_p - 1, 0);
                    right_p = left_p + 1;
                }
            } else {
                // No collision; move to the next pair
                left_p++;
                right_p++;
            }
        }

        if(grid.isEmpty()){
            return "0";
        }

        for (int fleet : grid){
            result.append(fleet).append(" ");
        }

        return result.toString().trim();
    }


//    public static String final_order(List<Integer> grid) {
//        StringBuilder result = new StringBuilder();
//
//        if (grid.isEmpty()) {
//            return "0";
//        }
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (int fleet : grid) {
//            boolean destroyed = false;
//
//            while (!stack.isEmpty() && fleet < 0 && stack.peek() > 0) {
//                if (Math.abs(fleet) > stack.peek()) {
//                    stack.pop();
//                } else if (Math.abs(fleet) == stack.peek()) {
//                    stack.pop();
//                    destroyed = true;
//                    break;
//                } else {
//                    destroyed = true;
//                    break;
//                }
//            }
//
//            if (!destroyed) {
//                stack.push(fleet);
//            }
//        }
//
//        if (stack.isEmpty()) {
//            return "0";
//        }
//
//        for (int fleet : stack) {
//            result.append(fleet).append(" ");
//        }
//
//        return result.toString().trim();
//    }

//    public static String final_order(List<Integer> grid){
//
//        StringBuilder result = new StringBuilder();
//
//        if(grid.isEmpty()){
//            return "0";
//        }
//
//        if(grid.size() <= 1){
//            return  Integer.toString(grid.get(0));
//        }
//
//        int left_p = 0;
//        int right_p =1;
//
//        while (left_p  >= 0 && right_p < grid.size()){
//
//            int player_x = grid.get(left_p);
//            int player_y = grid.get(right_p);
//
//            int player_x_abs = Math.abs(player_x);
//            int player_y_abs = Math.abs(player_y);
//
//            boolean player_x_is_neg = false;
//            boolean player_y_is_neg = false;
//
//            if(player_x < 0){
//                player_x_is_neg = true;
//            } else if (player_y < 0) {
//                player_y_is_neg = true;
//            }
//
//            //same power
//            if(player_x_abs == player_y_abs){
//
//                // same sign
//                if(player_x_is_neg == player_y_is_neg){
//                    left_p++;
//                    right_p++;
//                }
//
//                //oposite sign, same direction
//                else if (player_y_is_neg){
//                    if(grid.size() == 2){
//                        return "0";
//                    }else {
//
//                        // 5,10,-5,-1,-3,11,12,-3,-12
//                        // 5,10,11,12,-12
//
//                        grid.remove(right_p);
//                        grid.remove(left_p);
//
//                        //always be in the boundary
//                        left_p = Math.max(left_p - 1, 0);
//                        right_p = left_p + 1;
////                        left_p= right_p +1;
////                        right_p=left_p+1;
//                    }
//                }
//
//                //opposite sign, oppsite direction
//
//                else if(player_x_is_neg){
//                    left_p++;
//                    right_p++;
//                }
//
//            }
//            //different power
//            else {
//
//                //same sign
//
//                if(player_x_is_neg == player_y_is_neg){
//
//                    left_p++;
//                    right_p++;
//
//                }
//
//                //oposite sign, same direction
//                else if (player_y_is_neg){
//                        grid.remove(right_p);
//                }
//
//                //opposite sign, oppsite direction
//
//                else if(player_x_is_neg){
//                    left_p++;
//                    right_p++;
//                }
//
//
//
//            }
//
//        }
//
//        for (int fleet : grid){
//            result.append(fleet).append(" ");
//        }
//
//        return result.toString().trim();
//
//    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] grid = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<Integer> grid_list = new ArrayList<>();

            for (int fleet: grid){

                grid_list.add(fleet);

            }

            System.out.println(final_order(grid_list));

        }catch (Exception e){
            e.printStackTrace();
        }
//        runTestCases();
    }

    public static void runTestCases(){

        testcase( new ArrayList<>(Arrays.asList(5,10,-5,-1,-3,11,12,-3,-12)),"5 10 11" , 1);
        testcase(  new ArrayList<>(Arrays.asList(5,10,-5,-1,-3,11,12,-3)),"5 10 11 12", 2);
        testcase( new ArrayList<>(Arrays.asList(1)),"1",3);
        testcase(new ArrayList<>(Arrays.asList(8,-8,8)),"8",4);
        testcase( new ArrayList<>(Arrays.asList(-8 ,8 ,8)),"-8 8 8",5);
        testcase(new ArrayList<>(Arrays.asList(8 ,-8)),"0",6);
        testcase(new ArrayList<>(Arrays.asList(-8,8)),"-8 8",7);
        testcase(new ArrayList<>(Arrays.asList(5,10,-5)),"5 10",8);
        testcase(new ArrayList<>(Arrays.asList()),"0",9);
        testcase(new ArrayList<>(Arrays.asList(0,0 , -1 ,-2)),"0 0",10);
        testcase(new ArrayList<>(Arrays.asList(9 , -8 ,-1)),"9",11);
        testcase(new ArrayList<>(Arrays.asList(9 , 8, -8, -9)),"0",12);
        testcase(new ArrayList<>(Arrays.asList(9 , 8, -8, -9 , 10 ,-10)),"0",12);
    }

    public static void testcase(List<Integer> grid,String expected,int test){
        String result = final_order(grid);

        System.out.println(result);

        if(result.equals(expected)){
            System.out.println(test +" "+ "passed");
        }else {
            System.out.println(test + " " +"--Failed--");
        }
    }


}
