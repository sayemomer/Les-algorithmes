package Graph;

import javax.swing.*;
import java.util.*;

public class course_schedule {

    public static HashMap<Integer, ArrayList<Integer>> premap;
    public static Set<Integer> visiset;

    public static boolean dfs(int course){

        if(visiset.contains(course)){
            return false;
        }

        System.out.println(course);

        if(premap.get(course).isEmpty()){
            return true;
        }

        visiset.add(course);

        for (Integer crs:
             premap.get(course)) {

            if(!dfs(crs)){
                return false;
            }

        }
        visiset.remove(course);
        premap.put(course, new ArrayList<>());

        return true;

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        premap = new HashMap<>();
        visiset = new HashSet<>();


        for (int i = 0; i < numCourses; i++) {
            premap.put(i ,new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
                premap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        System.out.println(premap);
        System.out.println(prerequisites.length);

        for (int i = 0; i < numCourses ; i++) {

            if(!dfs(i)){
                return false;
            }

        }

        return true;

    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int num_of_course = Integer.parseInt(sc.nextLine());

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());

            int[][] prerequisites = new int[row][col];

            for (int i = 0; i < row; i++) {
                prerequisites[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(canFinish(num_of_course,prerequisites));


        }catch (Exception e){

            e.printStackTrace();

        }

    }
}
