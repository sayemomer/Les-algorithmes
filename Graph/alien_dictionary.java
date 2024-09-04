package Graph;

import java.util.Scanner;

public class alien_dictionary {

    public static String foreignDictionary(String[] words) {

//        ["hrn","hrf","er","enn","rfnn"]

        return "";

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] words = sc.nextLine().split(" ");

            System.out.println(foreignDictionary(words));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
