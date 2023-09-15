package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Identical_array {

    public static void checkIdentical(int[] a, int[] b, int len) {

        HashMap<Integer, Integer> hashA = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {

            hashA.put(a[i], i);

        }

        int x =0 ;

        for (int i = 0; i < b.length; i++) {

            if(hashA.containsKey(b[i])){
                if(hashA.get(b[i])!=i){
                    x++;
                }
                
            }else{
                System.out.println("NO");
                return;
            }
            
        }

        System.out.println(x);

        if ( x == 2 || x == 0){
            System.out.println("YES");
            return;
        }else{
            System.out.println("NO");
            return;
        }

    }

    public static int[] convertArr(String x, int len) {

        String[] carr1 = x.trim().split("\\s+");
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(carr1[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String lnt = scanner.nextLine();
            int Clnt = Integer.parseInt(lnt);
            String rarr1 = scanner.nextLine();
            String rarr2 = scanner.nextLine();

            int[] a1 = new int[Clnt];
            int[] a2 = new int[Clnt];

            a1 = convertArr(rarr1, Clnt);
            a2 = convertArr(rarr2, Clnt);

            checkIdentical(a1, a2, Clnt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
