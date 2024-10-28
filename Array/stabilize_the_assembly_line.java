package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class stabilize_the_assembly_line {

    public static void stabilizer(int[] raw_assembly_line, int threshold) {
        List<Integer> transformed_assembly_line = new ArrayList<>();
        int length = raw_assembly_line.length;

        // If the assembly line is smaller than the threshold, return it as is
        if (length < threshold) {
            for (int x : raw_assembly_line) {
                transformed_assembly_line.add(x);
            }
            printTransformedAssemblyLine(transformed_assembly_line);
            return;
        }

        // First pointer to traverse the list
        int first_pointer = 0;

        // Traverse the array
        while (first_pointer < length) {
            int current_track = raw_assembly_line[first_pointer];
            int count = 0;

            // Count the consecutive identical elements
            int second_pointer = first_pointer;
            while (second_pointer < length && raw_assembly_line[second_pointer] == current_track) {
                count++;
                second_pointer++;
            }

            // If we find exactly threshold identical elements, add only one of them
            if (count == threshold) {
                transformed_assembly_line.add(current_track);
            } else {
                // Otherwise, add all elements in this section
                for (int i = first_pointer; i < second_pointer; i++) {
                    transformed_assembly_line.add(raw_assembly_line[i]);
                }
            }

            // Move the first pointer to the end of the current segment
            first_pointer = second_pointer;
        }

        printTransformedAssemblyLine(transformed_assembly_line);
    }

    // Helper method to print the transformed assembly line
    private static void printTransformedAssemblyLine(List<Integer> transformed_assembly_line) {

        String result = "";
        for (int x : transformed_assembly_line) {
            result += x + " ";
        }
        System.out.println(result.trim());
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] raw_assembly_line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int threshold = Integer.parseInt(sc.nextLine());

            stabilizer(raw_assembly_line, threshold);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}