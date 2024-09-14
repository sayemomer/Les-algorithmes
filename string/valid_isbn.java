package string;

import java.util.Scanner;

public class valid_isbn {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String isbn = "007462542X";

            if(isbn.length() != 10){
                System.out.println("Invalid");
                return;
            }

            int i = 0;
            int isbn_cal  = 0;
            for (char x : isbn.toCharArray()) {


                if (!Character.isDigit(x) && x!='X') {

                    System.out.println("Invalid");
                    return;
                }

                if (x=='X' && i!=9) {
                    System.out.println("Invalid");
                    return;
                }

                if(x=='X'){
                    isbn_cal += 10 * (10-i);
                }else {
                    int y = Integer.parseInt(String.valueOf(x));
                    isbn_cal += y * (10-i);
                }

                i++;

            }

            System.out.println(isbn_cal);

            int reminder = isbn_cal%11;

            if(reminder >0){
                System.out.println("Invalid");
            }else {
                System.out.println("Valid");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
