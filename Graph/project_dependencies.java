package Graph;

import java.util.*;

public class project_dependencies {
    public LinkedHashMap<String, List<String>> premap;
    public Set<String> visitset;
    public Set<String> completedTasks;

    project_dependencies() {
        premap = new LinkedHashMap<>();
        visitset = new HashSet<>();
        completedTasks = new HashSet<>();
    }

    public boolean dfs(String projectOrTask) {


        if( premap.containsKey(projectOrTask) && premap.get(projectOrTask).isEmpty()){
            completedTasks.add(projectOrTask);
            return true;
        }
        if (completedTasks.contains(projectOrTask)) {
            return true;
        }

        if (visitset.contains(projectOrTask)) {
            return false;
        }

        if (!premap.containsKey(projectOrTask)) {
            return false;
        }

        visitset.add(projectOrTask);
        List<String> dependencies = premap.get(projectOrTask);

        for (String dependency : dependencies) {
            if (!dfs(dependency)) {
                return false;
            }
        }

        visitset.remove(projectOrTask);
        completedTasks.add(projectOrTask);
        return true;
    }

    public String checkDependency() {
        StringBuilder result = new StringBuilder();

        List<String> projects = new ArrayList<>(premap.keySet());
        Collections.sort(projects);


        for (String project : projects) {
            if (!completedTasks.contains(project)) {
                if (!dfs(project)) {
                    return "NONE";
                } else {
                    result.append(project).append("\n");
                }
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            project_dependencies project1 = new project_dependencies();
            int num = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < num; i++) {
                String projectName = sc.nextLine();
                String[] tasks = sc.nextLine().split(",");

                project1.premap.put(projectName, Arrays.asList(tasks));
            }



            String[] completedTasks = sc.nextLine().split(",");
            Collections.addAll(project1.completedTasks, completedTasks);

            System.out.println(project1.checkDependency());

        } catch (Exception e) {
            e.printStackTrace();
        }
//        runTestCases();
    }

    public static void runTestCases() {
        LinkedHashMap<String, List<String>> premap1 = new LinkedHashMap<>();
        premap1.put("projectA", Arrays.asList("task1", "task2"));
        premap1.put("projectB", Arrays.asList("projectA", "task3"));
        testCase(premap1, "projectA\nprojectB", new HashSet<>(Arrays.asList("task1", "task2", "task3")), 1);

        LinkedHashMap<String, List<String>> premap2 = new LinkedHashMap<>();
        premap2.put("projectA", Arrays.asList("task1", "projectB"));
        premap2.put("projectB", Arrays.asList("task2", "projectA"));
        testCase(premap2, "NONE", new HashSet<>(Arrays.asList("task1", "task2")), 2);

        LinkedHashMap<String, List<String>> premap3 = new LinkedHashMap<>();
        premap3.put("projectX", Arrays.asList("taskA", "taskB"));
        premap3.put("projectY", Arrays.asList("projectX", "taskC"));
        premap3.put("projectZ", Arrays.asList("taskD", "taskE"));
        testCase(premap3, "projectX\nprojectY\nprojectZ", new HashSet<>(Arrays.asList("taskA", "taskB", "taskC", "taskD", "taskE")), 3);

        LinkedHashMap<String, List<String>> premap4 = new LinkedHashMap<>();
        premap4.put("projectA", Arrays.asList("task1", "task2"));
        premap4.put("projectB", Arrays.asList("projectA", "task3"));
        premap4.put("projectC", Arrays.asList("projectB", "task4"));
        testCase(premap4, "NONE", new HashSet<>(Arrays.asList("task1")), 4);

        LinkedHashMap<String, List<String>> premap5 = new LinkedHashMap<>();
        premap5.put("projectX", Arrays.asList("taskA", "taskB"));
        premap5.put("projectY", Arrays.asList());
        premap5.put("projectZ", Arrays.asList("taskD", "taskE"));
//        premap5.put("projectA",Arrays.asList());
        testCase(premap5, "projectA\nprojectX\nprojectY\nprojectZ", new HashSet<>(Arrays.asList("taskA", "taskB", "taskC", "taskD", "taskE")), 5);
    }

    public static void testCase(LinkedHashMap<String, List<String>> premap, String expected, Set<String> completedTasks, int test) {
        project_dependencies testProject = new project_dependencies();
        testProject.premap = premap;
        testProject.completedTasks = completedTasks;

        String result = testProject.checkDependency();

        System.out.println(result);
        System.out.println(expected);

        if (result.equals(expected)) {
            System.out.println(test + " Passed");
        } else {
            System.out.println(test + " --FAILED--");
        }
    }
}
