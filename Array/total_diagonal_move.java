// Total Diagonal moves
// You’re given an N x N grid, the columns are represented as letters A, B, C and the rows are
// represented as numbers starting from 0. Find the minimum number of diagonal moves required
// to move from the source to destination.
// Diagonal moves are described as moving diagonally on the grid, if you’re moving A0 to C2 i.e.
// A0 -> B1 -> C2 then it counts as 1 move since they lie on the same diagonal. If you change
// the direction of diagonal, it will count as another move.
// Input:
// The first line represents N.
// The second line represents the starting location.
// The third line represents the destination location.
// Output:
// Print minimum number of diagonal moves, else print -1 if reaching the destination is not
// possible

// Example:
// Input:
// 3
// A0
// C2
// Output:
// 1


import java.util.*;

class total_diagonal_move {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String start = sc.next();
        String end = sc.next();
        int x1 = start.charAt(0) - 'A';
        int y1 = start.charAt(1) - '0';
        int x2 = end.charAt(0) - 'A';
        int y2 = end.charAt(1) - '0';
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        if (x == y) {
            System.out.println(1);
        } else if (x % 2 == 0 && y % 2 == 0) {
            System.out.println(2);
        } else if (x % 2 != 0 && y % 2 != 0) {
            System.out.println(2);
        } else {
            System.out.println(-1);
        }
    }
}
