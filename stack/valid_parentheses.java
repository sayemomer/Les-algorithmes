package stack;
import java.util.Scanner;
import java.util.Stack;

public class valid_parentheses {


    public static char getClosingParenthesis(char s){


        switch (s) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '!';
        }
        

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            //if the charecter is opening we are gonna put the in the stack
            //otherwise we are gonna check if the popped element from the stack,
            // is a according closing parenthesis 
            // if yes we pop , otherwise we return false

            char curr_char = s.charAt(i);

            //if its starts with closing parenthesis and the stack is emply return false

            if(curr_char == '(' || curr_char == '{' || curr_char == '['){
                stack.push(s.charAt(i));
            }else if(stack.isEmpty()){
                return false;
            }else{

                char popped_char = stack.pop();
                if(getClosingParenthesis(popped_char) == (curr_char)){
                    continue;
                }else{
                    return false;
                }

            }

            
        }

        //at the last we check if the stack is empty or not
        //if its empty we return true
        //else false

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();

            System.out.println(isValid(s));

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
