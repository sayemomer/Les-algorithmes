package Graph;

import java.util.Scanner;

public class surrounded_regions {

    public static void dfs(int row, int col, char[][] board){
        //check out of bound

        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] == 'X' || board[row][col] == 'T'){
            return;
        }

        //check boundary
            board[row][col] = 'T';
            dfs(row + 1 , col ,board);
            dfs(row - 1 , col ,board);
            dfs(row  , col + 1,board);
            dfs(row , col - 1,board);

    }

    public static void solve(char[][] board) {

        //ok, first we have to run through the grid and have check the connection for x

        //first row

        for (int i = 0; i < board[0].length; i++) {

            if(board[0][i] == 'O'  ) {
                dfs(0, i, board);
            }
        }

        //last row

        for (int i = 0; i < board[0].length; i++) {
            if(board[board.length -1 ][i] == 'O'  ) {
                dfs(board.length -1 , i, board);

            }
        }

        //first col

        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O'  ) {
                dfs(i, 0, board);

            }
        }

        //last col

        for (int i = 0; i < board.length; i++) {
            if(board[i][board[0].length -1 ] == 'O'  ) {
                dfs(i, board[0].length -1 , board);

            }
        }


        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {


                if(board[i][j] == 'T'  ){
                    board[i][j] = 'O';

                }else {
                    board[i][j] = 'X';
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println(board[i][j]);
            }
        }



    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int m = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());

            char[][] grid = new char[m][n];

            for (int i = 0; i < grid.length; i++) {
                String[] r = sc.nextLine().split(" ");
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = r[j].charAt(0);
                }
            }

            solve(grid);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
