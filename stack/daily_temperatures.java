package stack;

import java.util.Arrays;
import java.util.Scanner;

public class daily_temperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int tempdiff = 0;
            for (int j = i+1; j < temperatures.length; j++) {

                int curr_tempdiff = temperatures[j] - temperatures[i];

                if(  curr_tempdiff > tempdiff ){

                    tempdiff = j - i;
                    break;

                }
            }
            result[i] = tempdiff;
        }

        return result;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] temp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();;

            System.out.println(dailyTemperatures(temp));

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
