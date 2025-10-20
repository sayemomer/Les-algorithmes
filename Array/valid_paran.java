package Array;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class valid_paran {

    public static char getBracket(char a){

        if(a == ')'){
            return '(';
        } else if (a == ']') {
            return '[';

        }else {
            return '{';
        }

    }

    public static boolean isValid(String s) {

        Stack<Character> container = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{'){
                container.push(curr);
            }else {
                if(container.empty()){
                    return false;
                }

                if (container.peek() == getBracket(curr)){
                    container.pop();
                }else {
                    return false;
                }
            }
        }

        if(container.empty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();

            System.out.println(isValid(s));


        }catch (Exception e){

            System.out.println(e.getMessage());

        }

    }
}
