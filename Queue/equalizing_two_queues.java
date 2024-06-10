package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class equalizing_two_queues {
    public static int equalize(Queue<Integer> q1, Queue<Integer> q2) {
        int sum1 = q1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = q2.stream().mapToInt(Integer::intValue).sum();
        int counter = 0;
        HashMap<Integer,Integer>  ab = new HashMap<>();
        int magic = 0;

        while (sum1 != sum2 ) {

            int diff =  Math.abs(sum1 - sum2);
            // System.out.println(diff);
            // System.out.println(q1);
            // System.out.println(q2);

            if(sum1>sum2){
                magic = 1;
            }else{
                magic = 0;
            }

            if(ab.containsKey(diff)){
                int xy = ab.get(diff);
                if(xy == magic){
                    return -1;
                }
                
            }else{

                if(sum1>sum2){
                    ab.put(diff,magic);
                }else{
                    ab.put(diff,magic);
                }
                
            }

            if(q1.isEmpty() || q2.isEmpty()){
                return -1;
            }

            if(sum1>sum2){
                    int x = q1.poll();
                    q2.add(x);
                    counter++;
                
            }else{
                int z = q2.poll();
                q1.add(z);
                counter++;
                
            }

            sum1 = q1.stream().mapToInt(Integer::intValue).sum();
            sum2 = q2.stream().mapToInt(Integer::intValue).sum();
        }

        // System.out.println(q1);
        // System.out.println(q2);

        // System.out.println(ab);
        return counter;
    }


    public static void main(String[] args) {
        // TODO code application logic here

        try(Scanner sc = new Scanner(System.in)) {
            
            String s = sc.nextLine();
            String[] arr = s.split(" ");

            String m = sc.nextLine();
            String[] arr2 = m.split(" ");

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            for (int i = 0; i < arr.length; i++) {
                q1.add(Integer.parseInt(arr[i]));
            }

            for (int i = 0; i < arr2.length; i++) {
                q2.add(Integer.parseInt(arr2[i]));
            }

             System.out.println(equalize(q1, q2)); 
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        //init a queue with some elements
        // Queue<Integer> q1 = new java.util.LinkedList<>();
        // q1.add(1);
        // q1.add(2);
        // q1.add(1);
        // q1.add(2);

        // //init a queue with some elements
        // Queue<Integer> q2 = new java.util.LinkedList<>();
        // q2.add(1);
        // q2.add(10);
        // q2.add(1);
        // q2.add(2);

        // equalize(q1, q2);

        // // test for 1 1 and 1 3

        // Queue<Integer> q3 = new java.util.LinkedList<>();
        // q3.add(1);
        // q3.add(1);

        // Queue<Integer> q4 = new java.util.LinkedList<>();
        // q4.add(1);
        // q4.add(3);

        // equalize(q3, q4);

        // // test for 1 1 and 1 7

        // Queue<Integer> q5 = new java.util.LinkedList<>();
        // q5.add(1);
        // q5.add(1);

        // Queue<Integer> q6 = new java.util.LinkedList<>();
        // q6.add(1);
        // q6.add(7);

        // equalize(q5, q6);

        // //test for 1 1 and 1 1

        // Queue<Integer> q7 = new java.util.LinkedList<>();
        // q7.add(1);
        // q7.add(1);

        // Queue<Integer> q8 = new java.util.LinkedList<>();
        // q8.add(1);
        // q8.add(1);

        // equalize(q7, q8);

    }
    
}
