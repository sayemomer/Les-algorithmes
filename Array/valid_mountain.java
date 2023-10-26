import java.util.Arrays;
import java.util.Scanner;

class valid_mountain {
    public static boolean validMountainArray(int[] A) {

        if(A.length < 3){
            return false;
        }else{

            int max = Arrays.stream(A).max().getAsInt();
            int maxIndex = 0;

            for (int i = 0; i < A.length; i++) {
                if(A[i] == max){
                    maxIndex = i ;
                    break;
                }
            }

            if(maxIndex == (A.length -1) || maxIndex == 0 ){
                return false;
            }

            //3 4 5 2 3 1
            // 3 4 5 4 1

            //3 5 5
            //3 5 1

            //0 0 0 0 0

            // -1 0 -1

            //0 3 2 1 

            // 0 1 2 3 4 5 6 7 8 9

            // 9 8 7 6 5 4 3 2 1 0
            int[] x = Arrays.copyOfRange(A, 0, maxIndex);
            int[] y = Arrays.copyOfRange(A, maxIndex+1, A.length);
            // System.out.println(Arrays.toString(x));
            // System.out.println(Arrays.toString(y));

            double minx = Double.NEGATIVE_INFINITY ;

            for (int i = 0; i < x.length; i++) {
                if(x[i] < max &&  x[i] > minx ){
                    minx = x[i];
                }else{
                    return false;
                }
            }

            double miny = Double.NEGATIVE_INFINITY ;

            for (int i = y.length -1 ; i >= 0; i--) {
                if(y[i] < max &&  y[i] > miny ){
                    miny = y[i];
                }else{
                    return false;
                } 
            }

            return true;
            

        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            String arr[] = str.split(" ");

            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(arr[i]);
            }

            System.out.println(validMountainArray(A));


            //see this sol , its O(n) and less complex
            //https://leetcode.com/problems/valid-mountain-array/solutions/3200392/java-100-faster-solution/

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}