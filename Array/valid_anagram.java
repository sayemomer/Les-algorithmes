package Array;

public class valid_anagram {

    public static boolean isAnagram(String s, String t) {


        if(s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        java.util.Arrays.sort(s1);
        java.util.Arrays.sort(t1);

        //compare the sorted string
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != t1[i]) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }
    
}
