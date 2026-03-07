package Graph;

import java.util.*;

public class take_course {

    public static boolean dfs(int index,Set<Integer> visitSet,HashMap<Integer, List<Integer>> premap){

        if(visitSet.contains(index)){
            return false;
        }

        visitSet.add(index);

        for (int i:
             premap.get(index)) {
            dfs(i,visitSet,premap);

        }

        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> premap = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            premap.get(prerequisites[i][0]).add(prerequisites[i][1]);

        };

        return dfs(0, visitSet,premap);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int number_of_courses = Integer.parseInt(sc.nextLine());
            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            int[][] prereq = new int[row][col];

            System.out.println(canFinish(number_of_courses,prereq));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
