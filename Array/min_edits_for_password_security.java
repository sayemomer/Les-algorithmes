package Array;

import java.util.*;

public class min_edits_for_password_security {


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int len = Integer.parseInt(sc.nextLine());

            String[] passwords = sc.nextLine().split(" ");
            int[] min_change = new int[passwords.length];

            List<String> min_change_string = new ArrayList<>();

            Set<Character> special_char = new HashSet<>(Arrays.asList('@','#','$','%','&','*'));

            for (int i = 0; i < passwords.length; i++) {


                int y =0;
                //check length

                int count=0;

                // Check length (we need at least 10 characters)
                int lengthDiff = 0;
                if (passwords[i].length() < 10) {
                    lengthDiff = 10 - passwords[i].length(); // Need to add characters
                } else if (passwords[i].length() > 10) {
                    lengthDiff = passwords[i].length() - 10; // Need to remove characters
                }

                boolean isLowerCase = false;
                boolean isUpperCase = false;
                boolean isDigit = false;
                boolean is_special_char = false;


                //check uppercase

                for ( char x : passwords[i].toCharArray()) {

                    if(Character.isLowerCase(x) && isLowerCase == false){
                        isLowerCase = true;
                    }

                    if (Character.isUpperCase(x) && isUpperCase==false){
                        isUpperCase = true;
                    }
                    if (Character.isDigit(x) && isDigit == false){
                        isDigit = true;
                    }

                    if (special_char.contains(x) && is_special_char == false){
                        is_special_char = true;
                    }

                }

                // Count missing character types
                int missingCriteria = 0;
                if (!isLowerCase) missingCriteria++;
                if (!isUpperCase) missingCriteria++;
                if (!isDigit) missingCriteria++;
                if (!is_special_char) missingCriteria++;

                // Add the number of missing criteria to the count
                count = Math.max(missingCriteria, lengthDiff);

                // Ensure count reflects the maximum of the two (either adding characters or missing criteria)

                min_change[i] = count;

            }

            int min = Arrays.stream(min_change).min().orElseThrow();

            for (int i = 0; i < min_change.length; i++) {

                if(min_change[i] == min){
                    min_change_string.add(passwords[i]);
                }

            }

            String minPassword = null;
            for (int i = 0; i < min_change.length; i++) {
                if (min_change[i] == min) {
                    // If this is the first candidate or lexicographically smaller, update the candidate
                    if (minPassword == null || passwords[i].compareTo(minPassword) < 0) {
                        minPassword = passwords[i];
                    }
                }
            }

            System.out.println(min_change_string.get(0));
            System.out.println(min);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
