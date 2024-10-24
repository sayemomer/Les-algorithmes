package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class element_composition_analysis {

    public static String complexBreaker(String formula) {
        StringBuilder result = new StringBuilder();

        String[] molecules = formula.split("");
        HashMap<String, Integer> molecule_count = new HashMap<>();

        Stack<String> moleculerStack = new Stack<>();

        for (int i = 0; i < molecules.length; i++) {
            String mol = molecules[i];

            // If it's a letter, handle the element symbol
            if (Character.isLetter(mol.charAt(0))) {
                // Handle multi-character elements (e.g., "Mg")
                while (i + 1 < molecules.length && Character.isLowerCase(molecules[i + 1].charAt(0))) {
                    mol += molecules[i + 1];
                    i++;
                }

                // Check if there is a digit immediately following the element (its count)
                int count = 1;
                StringBuilder numberBuilder = new StringBuilder();
                while (i + 1 < molecules.length && Character.isDigit(molecules[i + 1].charAt(0))) {
                    numberBuilder.append(molecules[i + 1]);
                    i++;
                }
                if (numberBuilder.length() > 0) {
                    count = Integer.parseInt(numberBuilder.toString());
                }

                moleculerStack.push(mol);
                moleculerStack.push(String.valueOf(count));

            } else if (mol.equals("(")) {
                // Push open parenthesis onto the stack
                moleculerStack.push("(");

            } else if (mol.equals(")")) {
                // Handle elements within parentheses
                HashMap<String, Integer> moleculeBucket = new HashMap<>();

                // Get the multiplier for the group of elements within parentheses
                int multiplier = 1;
                StringBuilder multiplierBuilder = new StringBuilder();
                if (i + 1 < molecules.length && Character.isDigit(molecules[i + 1].charAt(0))) {
                    while (i + 1 < molecules.length && Character.isDigit(molecules[i + 1].charAt(0))) {
                        multiplierBuilder.append(molecules[i + 1]);
                        i++;
                    }
                    multiplier = Integer.parseInt(multiplierBuilder.toString());
                }

                // Process elements inside the parentheses
                while (!moleculerStack.peek().equals("(")) {
                    int num = Integer.parseInt(moleculerStack.pop());
                    String element = moleculerStack.pop();

                    moleculeBucket.put(element, moleculeBucket.getOrDefault(element, 0) + num * multiplier);
                }

                // Pop the opening parenthesis
                moleculerStack.pop();

                // Push the updated counts back onto the stack
                for (Map.Entry<String, Integer> entry : moleculeBucket.entrySet()) {
                    moleculerStack.push(entry.getKey());
                    moleculerStack.push(String.valueOf(entry.getValue()));
                }

            } else {
                // If it's a digit or something else, just push it to the stack
                moleculerStack.push(mol);
            }
        }

        // Now, we need to calculate the final count of each element
        while (!moleculerStack.isEmpty()) {
            int count = Integer.parseInt(moleculerStack.pop());
            String element = moleculerStack.pop();

            molecule_count.put(element, molecule_count.getOrDefault(element, 0) + count);
        }

        // Build the result by sorting the elements lexicographically
        molecule_count.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    result.append(entry.getKey());
                    if (entry.getValue() > 1) {
                        result.append(entry.getValue());
                    }
                });

        return result.toString();
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String formula = sc.nextLine();

            System.out.println(complexBreaker(formula));

        }catch (Exception e){
            e.printStackTrace();
        }
//        runTestCases();
    }

//    public static void runTestCases() {
//        testcase("K4(ON(SO3)2)2", "K4N2O14S4", 1);
//        testcase("Mg(OH)2", "H2MgO2", 2);
//        testcase("Mg(OH2)2", "H4MgO2", 3);
//        testcase("H2O", "H2O", 4);
//        testcase("H20", "H20", 5); // Adding test case for H20
//    }
//
//    public static void testcase(String formula, String expected, int testcase) {
//        String result = complexBreaker(formula);
//
//        if (result.equals(expected)) {
//            System.out.println(testcase + " Passed");
//        } else {
//            System.out.println(testcase + " --FAILED-- Expected: " + expected + ", but got: " + result);
//        }
//    }
}
