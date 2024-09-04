package Sorting;

import java.util.*;

public class group_anagrams {


    public static List<List<String>> groupAnagrams_v2(String[] strs) {

//        eat tea tan ate nat bat
        List<List<String>> group_anagrams = new ArrayList<>();

        //first we need to create a hashmap of all possible group letter list

        HashMap<String,List<String>> letter_count_map = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {

            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String newstr = new String(word);

            //now we check this letter_map exits in the letter_count_map or not
            //if its not we create a new map with a empty list
            //otherwise we add the new word in that map

            if(letter_count_map.containsKey(newstr)){
                letter_count_map.get(newstr).add(strs[i]);
            }else {
                List<String> x =  new ArrayList<>();
                x.add(strs[i]);
                letter_count_map.put(newstr,x);
            }
        }

        for (Map.Entry<String,List<String>> map: letter_count_map.entrySet() ){

            group_anagrams.add(map.getValue());

        }

        return  group_anagrams;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

//        eat tea tan ate nat bat
        List<List<String>> group_anagrams = new ArrayList<>();

        //first we need to create a hashmap of all possible group letter list

        HashMap<HashMap<String,Integer>,List<String>> letter_count_map = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {
            HashMap<String,Integer> letter_map = new HashMap<>();
            String[] splited_word = strs[i].split("");

            for (String letter : splited_word){

                letter_map.put(letter,letter_map.getOrDefault(letter,0)+1);
            }

            //now we check this letter_map exits in the letter_count_map or not
            //if its not we create a new map with a empty list
            //otherwise we add the new word in that map

            if(letter_count_map.containsKey(letter_map)){
                letter_count_map.get(letter_map).add(strs[i]);
            }else {
               List<String> x =  new ArrayList<>();
               x.add(strs[i]);
               letter_count_map.put(letter_map,x);
            }
        }

        for (Map.Entry<HashMap<String,Integer>,List<String>> map: letter_count_map.entrySet() ){

            group_anagrams.add(map.getValue());

        }

        return  group_anagrams;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] strs = sc.nextLine().split(" ");

            System.out.println(groupAnagrams(strs));


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
