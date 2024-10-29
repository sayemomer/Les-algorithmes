package Graph;

import java.util.*;

public class course_schedule_II {

    public static HashSet<Integer> visitset;

    public static List<Integer> course_order;
    public static HashMap<Integer,List<Integer>> premap;

//    {0=[], 1=[0], 2=[0], 3=[1, 2]}
    public static boolean dfs(int i){

        if(course_order.contains(i)){
            return true;
        }

        if(premap.get(i).isEmpty()){
            course_order.add(i);
            return true;
        }

        if(visitset.contains(i)){
            return false;
        }

        visitset.add(i);

        List<Integer> pris = premap.get(i);

        for (int p_course : pris ){

            if(!dfs(p_course)){
                return false;
            }

        }

        visitset.remove(i);
        course_order.add(i);
        return true;

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        visitset = new HashSet<>();
        course_order = new ArrayList<>();
        premap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            premap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequsite = pre[1];
            if(premap.containsKey(course)){
                premap.get(course).add(prerequsite);
            }else {
                premap.put(course, new ArrayList<>(Collections.singletonList(prerequsite)));
            }
        }


        for (int course : premap.keySet()){
            if(!dfs(course)){
                return new int[0];
            }
        }

        return course_order.stream().mapToInt(Integer::intValue).toArray();

    }
    public static void main(String[] args) {

        System.out.println(findOrder(2,new int[][]{{1,0},{2,0},{3,1},{3,2}}) );

    }
}
