package string;

public class longest_common_prefix {

    public static String longestCommonPrefix(String[] strs) {

        String[] letMatch = strs[0].split("");

        for (int i = 1; i < strs.length; i++) {

            String[] x = strs[i].split("");

            for ( int j =0 ; j< x.length ; j++){

                if(x[j] == letMatch[j]){
                    System.out.println();
                }
            }
            
        }
        return "";
        
    }

    public static void main(String[] args) {

        String[] words = {"flower","flow","flight"};
        longestCommonPrefix(words);
    }

    
}
