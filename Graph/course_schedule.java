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

//test cases

//        2
//        2
//        2
//        1 0
//        0 1
//
//        4
//        4
//        2
//        1 3
//        1 0
//        3 2
//        2 3
//
//        4
//        3
//        2
//        1 0
//        3 1
//        2 3
//
//        2
//        1
//        2
//        0 1
//
//        7
//        8
//        2
//        1 0
//        0 3
//        0 2
//        3 2
//        2 5
//        4 5
//        5 6
//        2 4
//
//        5
//        4
//        2
//        1 0
//        2 1
//        3 4
//        4 3
