package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class find_recipe {

    public static void findRE(LinkedHashMap<String, ArrayList<String>> recipe, ArrayList<String> supplList){

        ArrayList<String> output = new ArrayList<>();

        for (Map.Entry<String,ArrayList<String>> a : recipe.entrySet()) {
            int counter = 0;

            ArrayList<String> recip = new ArrayList<>();
            recip = a.getValue();

            for (String string : recip) {
                if(supplList.contains(string)){
                    counter++;
                }
                
            }

            if(counter == recip.size()){
                output.add(a.getKey());
                supplList.add(a.getKey());
            }
        }

        Collections.sort(output);

        if(output.size() == 0){
            output.add("NONE");
        }else{
            for (String string : output) {
            System.out.println(string);
        }
        }
        

    }

    public static void main(String[] args) {


// 3
// bread
// yeast,flour
// sandwich
// bread,meat
// burger
// sandwich,meat,bread
// yeast,flour,meat

// 1
// bread
// yeast,flour
// yeast,flour,corn

        try(Scanner sc = new Scanner(System.in)) {

            int numberOfrecipe = Integer.parseInt(sc.nextLine()) ;

            LinkedHashMap<String, ArrayList<String>> recipe = new LinkedHashMap<String, ArrayList<String>>();

            for (int i = 0; i < numberOfrecipe ; i++) {
                String nameofre = sc.nextLine();
                String[] ingrdt = sc.nextLine().split(",");
                ArrayList<String> ingredients = new ArrayList<String>();
                ingredients.addAll(Arrays.asList(ingrdt));
                recipe.put(nameofre, ingredients);
            }

            String[] suppl = sc.nextLine().split(",");
            ArrayList<String> supplList = new ArrayList<>();
            supplList.addAll(Arrays.asList(suppl));
            findRE(recipe, supplList);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
