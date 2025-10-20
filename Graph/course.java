package Graph;

import java.util.*;

public class course {


    public static boolean dfs(int course,HashMap<Integer,ArrayList<Integer>> premap,Set<Integer> visitset){
        //we will first get rid of the easy cases
        //if the course is already in the visitSet, that means selfLoop

        if(visitset.contains(course)){
            return false;
        }

        //then we check for couse without any prereq

        if(premap.get(course).isEmpty()){
            return true;
        }

        //we put that into visitSet

        visitset.add(course);

        //then call DFS for this course

        for (Integer cour: premap.get(course)){
            if(!dfs(cour,premap,visitset)){
                return false;
            }
        }

        //remove that from visitSet

        visitset.remove(course);
        premap.put(course, new ArrayList<>());

        return true;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean can_finish = true;



        //ok first I need the premap of each course , because a course can be pre-req of more than one course
        // that pre map can should be global , coz after finishing the course dfs we should make it empty ,because its done

        // create the hashmap

        HashMap<Integer, ArrayList<Integer>> premap = new HashMap<>();
        Set<Integer> visitset = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            premap.put(i,new ArrayList<>());
        }

        //populate the hashmap

        // 1 0
        // 0 1

        for (int i = 0; i < prerequisites.length; i++) {
            premap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //now we call dfs for each of the cours



        for (int i = 0; i < numCourses; i++) {

            //if the number is already is in visitset that means it has self-loop
            // if the course doesn't have any preq , that means it can be done first
            //ok, lets gooo first write the dfs

            if(!dfs(i,premap,visitset)){
                return false;
            }

        }

        return can_finish;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            int num_of_courses = Integer.parseInt(sc.nextLine());

            int row = Integer.parseInt(sc.nextLine());

            int[][] prerequisites = new  int[row][2];

            for (int i = 0; i < prerequisites.length; i++) {

                prerequisites[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            System.out.println(canFinish(num_of_courses,prerequisites));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
