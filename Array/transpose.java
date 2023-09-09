package Array;

public class transpose {


    public static void printMatrix(int[][] table ){

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++)
                System.out.print(table[row][col] + "\t");
            System.out.println();
        }

        System.out.println();


    }
    public static void main(String[] args) {

        int[][] table = new int[5][10];
        for (int row = 0; row < table.length; row++)
            for (int col = 0; col < table[row].length; col++)
                table[row][col] = row * 10 + col;

        printMatrix(table);

        int[][] transpose_matrix = new int[10][5];
        
        for ( int i = 0 ; i< 10 ; i++){
            for ( int j =0 ; j < 5 ; j++){
                transpose_matrix[i][j] = table[j][i];
            }
        }

        printMatrix(transpose_matrix);
        

    }
}
