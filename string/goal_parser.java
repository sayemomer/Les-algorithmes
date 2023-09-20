
//https://leetcode.com/problems/goal-parser-interpretation/submissions/

package string;

public class goal_parser {

    public static String interpret(String command) {

        String cString = command.replace("()", "o").replace("(al)", "al");

        return cString;
        
    }

    public static void main(String[] args) {

        interpret("G()(al)");
        interpret("G()()()()(al)");
        interpret("(al)G(al)()()G");
        
    }
    
}
