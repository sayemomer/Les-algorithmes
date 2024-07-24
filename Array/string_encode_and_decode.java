package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class string_encode_and_decode {

    public static String encode(List<String> strs) {
        
        String encoded_str = "";

        for (String s : strs){
            int length = s.length();
            encoded_str+= length + "#" + s;
        }

        return encoded_str;

    }

    public static List<String> decode(String str) {


        // 4#neet4#code4#love3#you

        ArrayList<String> decoded_string = new ArrayList<>();

        int i =0;


        while (i< str.length()){
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            // Extract the substring of the given length
            String des = str.substring(j + 1, j + 1 + length);
            decoded_string.add(des);

            // Move the index to the next encoded substring
            i = j + 1 + length;
        }


        return decoded_string;
    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            ArrayList<String> inp = new ArrayList<>();

            String[] inp_s = sc.nextLine().split(" ");

            for (int i = 0; i < inp_s.length; i++) {
                inp.add(inp_s[i]);
            }

            String encoded_str = encode(inp);

            System.out.println("After encoding..");
            System.out.println(encoded_str);
            System.out.println("After Decoding..");
            System.out.println(decode(encoded_str));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
