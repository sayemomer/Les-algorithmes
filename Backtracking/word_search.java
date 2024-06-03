package Backtracking;

import java.util.Scanner;

public class word_search {


    //test cases

    // 3
    // 4
    // A B C E
    // S F C S
    // A D E E
    // ABCCED


    // 3
    // 4
    // A B C E
    // S F C S
    // A D E E
    // ABCB

    // 3
    // 3
    // C A A
    // A A A
    // B C D
    // AAB

    public static boolean dfs(char[][] board, String word, int row, int col, int index){

        // here we recursively search for pattern that can be match linearly

        // A B C E
        // S F C S
        // A D E E

        //now we need a base case to stop 
        if(index == word.length()){
            return true;
        }
        

        //now we need some validation criteria so that the scanner is not our of bound
        if(row < 0 || row>=board.length || col < 0 || col >=board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];

        board[row][col] = ' ';

        // now we backtrack , here we check left , right, top , bottom

        boolean is_found =  dfs(board, word, row , col + 1, index+1) || 
                            dfs(board, word, row, col-1, index+1)   ||
                            dfs(board, word, row+1, col, index +1 ) ||
                            dfs(board, word, row-1, col, index+1);

        board[row][col] = temp;

        return is_found;
    }

    public static boolean exist(char[][] board, String word) {

        //ok first print the first char if match from the grid

        boolean is_found = false;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                //now from here we do the dfs search

                if( board[i][j] == word.charAt(0) && dfs(board, word,i,j,0)){
                    is_found = true;
                    break;

                }
            }
        }

        return is_found;
        
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            char[][] grid = new char[row][col];

            for (int i = 0; i < row; i++) {
                String[] grid_s = sc.nextLine().split(" ");
                for (int j = 0; j < col; j++) {
                    grid[i][j] = grid_s[j].charAt(0);
                }
            }

            String word = sc.nextLine();

            System.out.println(exist(grid, word));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
