package string;

import java.util.Scanner;

public class finding_the_minimum_character_shifts {

    public static int min_char_shift_v2(String src,String tar){

        int result = -1;

        if(src.length() != tar.length()){
            result=-1;
            return result;
        }

        if(src.equals(tar)){
            result =0;
            return result;
        }

        String concated = src.concat(src);

        result = concated.indexOf(tar);

        return result;

    }

    public static int min_char_shift(String src,String tar){

        int result = -1;

        if(src.length() != tar.length()){
            result=-1;
            return result;
        }

        if(src.equals(tar)){
            result =0;
            return result;
        }

        String concated = src.concat(src);

        int src_p = 0;
        int tar_p = tar.length();

        while (src_p < concated.length() && tar_p < concated.length()){

            //in java substring the last one is exclusive
            String sub_str = concated.substring(src_p,tar_p);
            if(sub_str.equals(tar)){
                result = src_p;
                break;
            }
            src_p++;
            tar_p++;
        }

        return result;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] line = sc.nextLine().split(" ");
            String src = line[0];
            String tar = line[1];

//            System.out.println(min_char_shift(src,tar));
            System.out.println(min_char_shift_v2(src,tar));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
