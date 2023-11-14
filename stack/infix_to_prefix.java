package stack;
import java.util.Scanner;
import java.util.Stack;

public class infix_to_prefix {

    // Function to check if the given character is an operand
    private static boolean isOperand(char ch) {
        return ch != '(' && ch != ')' && ch != '+' && ch != '-' && ch != '*' && ch != '/';
    }

    // Function to return the precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '-':
                return 0;
            case '+':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to postfix
    private static String infixToPostfix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            if (isOperand(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    // Function to reverse a string
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    // Function to replace parentheses
    private static String replaceParentheses(String str) {
        str = str.replace('(', 'x');
        str = str.replace(')', '(');
        str = str.replace('x', ')');
        return str;
    }

    // Function to convert infix to prefix
    public static String infixToPrefix(String expression) {
        expression = reverse(expression);
        expression = replaceParentheses(expression);
        expression = infixToPostfix(expression);
        return reverse(expression);
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){


        String infixExpression = sc.nextLine();
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println(prefixExpression);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
