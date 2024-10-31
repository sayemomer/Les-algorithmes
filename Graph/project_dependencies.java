package Graph;

import java.util.*;

public class project_dependencies {

    public Map<String, Set<String>> projectDependencies;
    public Map<String, Set<String>> dependencyToProjects;
    public Set<String> completedTasks;
    public Set<String> completedProjects;
    public Set<String> allProjects;
    public Set<String> allTasks;
    public List<String> completionOrder;

    project_dependencies() {
        projectDependencies = new HashMap<>();
        dependencyToProjects = new HashMap<>();
        completedTasks = new HashSet<>();
        completedProjects = new HashSet<>();
        allProjects = new HashSet<>();
        allTasks = new HashSet<>();
        completionOrder = new ArrayList<>();
    }

    public String checkDependency() {
        Queue<String> availableProjects = new PriorityQueue<>();

        // Initially, find projects whose dependencies are already met
        for (String project : allProjects) {
            Set<String> dependencies = projectDependencies.getOrDefault(project, new HashSet<>());
            boolean allDependenciesMet = true;
            for (String dependency : dependencies) {
                if (!completedTasks.contains(dependency) && !completedProjects.contains(dependency)) {
                    allDependenciesMet = false;
                    break;
                }
            }
            if (allDependenciesMet) {
                availableProjects.offer(project);
            }
        }

        Set<String> processedProjects = new HashSet<>();
        while (!availableProjects.isEmpty()) {
            // Get all projects that can be completed at this step
            List<String> currentProjects = new ArrayList<>();
            currentProjects.add(availableProjects.poll());

            // Check if other projects can also be completed at this time
            while (!availableProjects.isEmpty() && availableProjects.peek().equals(currentProjects.get(0))) {
                currentProjects.add(availableProjects.poll());
            }

            // Sort projects alphabetically
            Collections.sort(currentProjects);

            // Complete the projects
            for (String project : currentProjects) {
                if (completedProjects.contains(project)) {
                    continue;
                }
                completedProjects.add(project);
                completionOrder.add(project);
                // Update dependencies of other projects
                for (String dependentProject : dependencyToProjects.getOrDefault(project, new HashSet<>())) {
                    if (processedProjects.contains(dependentProject)) {
                        continue;
                    }
                    Set<String> dependencies = projectDependencies.get(dependentProject);
                    boolean allDependenciesMet = true;
                    for (String dependency : dependencies) {
                        if (!completedTasks.contains(dependency) && !completedProjects.contains(dependency)) {
                            allDependenciesMet = false;
                            break;
                        }
                    }
                    if (allDependenciesMet) {
                        availableProjects.offer(dependentProject);
                        processedProjects.add(dependentProject);
                    }
                }
            }
        }

        // Check if all projects are completed
        if (completedProjects.size() != allProjects.size()) {
            return "NONE";
        }

        // Return the completion order
        StringBuilder result = new StringBuilder();
        for (String project : completionOrder) {
            result.append(project).append("\n");
        }
        return result.toString().trim();
    }

    public boolean detectCycles() {
        // Perform DFS to detect cycles
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();

        for (String project : allProjects) {
            if (detectCyclesUtil(project, visited, recursionStack)) {
                return true; // Cycle detected
            }
        }
        return false;
    }

    private boolean detectCyclesUtil(String project, Set<String> visited, Set<String> recursionStack) {
        if (recursionStack.contains(project)) {
            return true; // Cycle detected
        }
        if (visited.contains(project)) {
            return false;
        }
        visited.add(project);
        recursionStack.add(project);

        Set<String> dependencies = projectDependencies.getOrDefault(project, new HashSet<>());
        for (String dependency : dependencies) {
            if (allProjects.contains(dependency)) {
                if (detectCyclesUtil(dependency, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack.remove(project);
        return false;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            project_dependencies projectDeps = new project_dependencies();
            int num = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < num; i++) {
                String projectName = sc.nextLine().trim();
                String dependencyLine = sc.nextLine().trim();

                projectDeps.allProjects.add(projectName);

                Set<String> dependencies = new HashSet<>();
                if (!dependencyLine.isEmpty()) {
                    String[] tasks = dependencyLine.split(",");
                    for (String task : tasks) {
                        task = task.trim();
                        if (!task.isEmpty()) {
                            dependencies.add(task);
                            if (projectDeps.allProjects.contains(task)) {
                                // Dependency is a project
                                projectDeps.dependencyToProjects.computeIfAbsent(task, k -> new HashSet<>()).add(projectName);
                            } else {
                                // Dependency is a task
                                projectDeps.allTasks.add(task);
                            }
                        }
                    }
                }

                projectDeps.projectDependencies.put(projectName, dependencies);
            }

            String completedTasksLine = sc.nextLine().trim();
            if (!completedTasksLine.isEmpty()) {
                String[] completedTasks = completedTasksLine.split(",");
                for (String task : completedTasks) {
                    task = task.trim();
                    if (!task.isEmpty()) {
                        projectDeps.completedTasks.add(task);
                    }
                }
            }

            // Detect cycles
            if (projectDeps.detectCycles()) {
                System.out.println("NONE");
                return;
            }

            String result = projectDeps.checkDependency();
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void runTestCases() {
//        LinkedHashMap<String, List<String>> premap1 = new LinkedHashMap<>();
//        premap1.put("projectA", Arrays.asList("task1", "task2"));
//        premap1.put("projectB", Arrays.asList("projectA", "task3"));
//        testCase(premap1, "projectA\nprojectB", new HashSet<>(Arrays.asList("task1", "task2", "task3")), 1);
//
//        LinkedHashMap<String, List<String>> premap2 = new LinkedHashMap<>();
//        premap2.put("projectA", Arrays.asList("task1", "projectB"));
//        premap2.put("projectB", Arrays.asList("task2", "projectA"));
//        testCase(premap2, "NONE", new HashSet<>(Arrays.asList("task1", "task2")), 2);
//
//        LinkedHashMap<String, List<String>> premap3 = new LinkedHashMap<>();
//        premap3.put("projectX", Arrays.asList("taskA", "taskB"));
//        premap3.put("projectY", Arrays.asList("projectX", "taskC"));
//        premap3.put("projectZ", Arrays.asList("taskD", "taskE"));
//        testCase(premap3, "projectX\nprojectY\nprojectZ", new HashSet<>(Arrays.asList("taskA", "taskB", "taskC", "taskD", "taskE")), 3);
//
//        LinkedHashMap<String, List<String>> premap4 = new LinkedHashMap<>();
//        premap4.put("projectA", Arrays.asList("task1", "task2"));
//        premap4.put("projectB", Arrays.asList("projectA", "task3"));
//        premap4.put("projectC", Arrays.asList("projectB", "task4"));
//        testCase(premap4, "NONE", new HashSet<>(Arrays.asList("task1")), 4);
//
//        LinkedHashMap<String, List<String>> premap5 = new LinkedHashMap<>();
//        premap5.put("projectX", Arrays.asList("taskA", "taskB"));
//        premap5.put("projectY", Arrays.asList());
//        premap5.put("projectZ", Arrays.asList("taskD", "taskE"));
////        premap5.put("projectA",Arrays.asList());
//        testCase(premap5, "projectA\nprojectX\nprojectY\nprojectZ", new HashSet<>(Arrays.asList("taskA", "taskB", "taskC", "taskD", "taskE")), 5);
//    }
//
//    public static void testCase(LinkedHashMap<String, List<String>> premap, String expected, Set<String> completedTasks, int test) {
//        project_dependencies testProject = new project_dependencies();
//        testProject.dependencyToProjects = premap;
//        testProject.completedTasks = completedTasks;
//
//        String result = testProject.checkDependency();
//
//        System.out.println(result);
//        System.out.println(expected);
//
//        if (result.equals(expected)) {
//            System.out.println(test + " Passed");
//        } else {
//            System.out.println(test + " --FAILED--");
//        }
//    }
}
