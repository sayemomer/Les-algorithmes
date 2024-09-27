package stack;

import java.util.*;

public class the_wizard_lockbox {


    public static char getClosingBracket(Character x){

        if (x.equals('{')){
            return '}';
        } else if (x.equals('[')) {
            return ']';
        } else if (x.equals('(')) {
            return ')';
        }

        return '!';
    }

    public static boolean checkLock(String lock){
        boolean result = false;

        Stack<Character> magic_stack = new Stack<>();
        Set<Character> decoy_symbols = new HashSet<>(Arrays.asList('@','*','#'));
        Set<Character> all_symbols = new HashSet<>(Arrays.asList('[',']','{','}','(',')'));


        char[] lock_seq = lock.toCharArray();
        int angel_treshold = 1;


        for (int i = 0; i < lock_seq.length; i++) {

            char curr = lock_seq[i];

            if (curr =='{' || curr == '[' || curr == '('){

                magic_stack.push(curr);

            } else if (curr =='<' ) {

                if (angel_treshold==0){
                    angel_treshold--;
                    break;
                }else {

                    for (int j = i; j < lock_seq.length; j++) {

                        char c = lock_seq[j];
                        if(decoy_symbols.contains(c)){
                            continue;
                        } else if (all_symbols.contains(c)) {
                            return false;
                        }else if (c =='>'){
                            angel_treshold--;
                            i=j;
                            break;
                        }
                    }
                }

            } else if (decoy_symbols.contains(lock_seq[i])) {
                continue;
            } else if (magic_stack.isEmpty()) {
                return false;

            } else {

                    char y = magic_stack.pop();

                    if (getClosingBracket(y) == curr){
                        continue;
                    }else {
                        return false;
                    }
            }


        }

        if (magic_stack.isEmpty() && angel_treshold>=0){
            return true;
        }else {
            return result;
        }

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String lock_box = sc.nextLine();

            System.out.println(checkLock(lock_box));

        }catch (Exception e){
            e.printStackTrace();
        }

//        runTestCases();
    }

//    public static void runTestCases(){
//        testcase("{[()]*}" , true,1);
//        testcase("[*(])" , false,2);
//        testcase("{@#}*" , true,3);
//        testcase("{[<>]@}" , true,4);
//        testcase("(<*@>)" , true,5);
//        testcase("(<><>)()" , false,6);
//        testcase("" , true,7);
//        testcase("[***" , false,8);
//        testcase("<>" , true,9);
//
//    }
//
//    public static void testcase(String pattern, boolean expected,int testcase){
//
//        boolean result = checkLock(pattern);
//        System.out.println(result);
//
//        if (result == expected){
//            System.out.println(testcase+" "+"passed");
//        }else {
//            System.out.println(testcase+" "+"----Failed------");
//        }
//
//    }
}
