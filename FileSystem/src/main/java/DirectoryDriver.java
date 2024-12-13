import java.util.Scanner;

/**
 * Name and ID: Omer Sayem, 40226505
 * Assignments 3
 * Due Date: 30 november 2024
 */


public class DirectoryDriver {
    public static void main(String[] args) {
        /**
         *  1
         */
        Directory root = new Directory("root", false);

        /**
         * 2
         */


        root.addDirectory("subDir1");
        root.addDirectory("subDir2");
        root.addDirectory("subDir3");
        root.addDirectory("subDir4");
        root.addDirectory("subDir5");
        root.addDirectory("subDir6");
        root.addDirectory("subDir7");
        root.addDirectory("subDir8");
        root.addDirectory("subDir9");

        // Add files to the root directory
        root.addFile("file1.txt");
        root.addFile("file2.txt");
        root.addFile("file3.txt");

        // Add files to subdirectories

        root.getD_children().get(0).addFile("subDir1_file1.txt");
        root.getD_children().get(1).addFile("subDir2_file1.txt");
        root.getD_children().get(2).addFile("subDir3_file1.txt");
        root.getD_children().get(3).addFile("subDir4_file1.txt");
        root.getD_children().get(4).addFile("subDir5_file1.txt");

        // Add nested directories and files

        //.addFile("nested_file1.txt");

        root.getD_children().get(5).addDirectory("nestedDirectory");

        root.getD_children().get(5).getD_children().get(0).addFile("nestedFile");

        root.printDirectoryStructure();

        // Get size of the root directory
        System.out.println("\nTotal size of root: " + root.getSize());

        // Find file
        String filePath = root.findFile("subDir5_file1.txt");
        if (filePath != null) {
            System.out.println("\nFile found at: " + filePath);
        } else {
            System.out.println("\nFile not found.");
        }

        // Handle cases with non-existent files
        String missingFile = root.findFile("notexist.txt");
        System.out.println("\nFinding a non-existent file: " + (missingFile == null ? "File not found" : missingFile));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;


        while (!exit) {
            System.out.println("\n========== Directory Menu ==========");
            System.out.println("1. Insert a new file");
            System.out.println("2. Insert a new directory");
            System.out.println("3. Print directory structure");
            System.out.println("4. Search for a file");
            System.out.println("5. Get size of a directory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    // Insert a new file
                    System.out.print("Enter the directory path where you want to add the file (e.g., root/subDir1): ");
                    String dirPathForFile = scanner.nextLine().trim();
                    Directory dirForFile = findDirectoryByPath(root, dirPathForFile);
                    if (dirForFile == null) {
                        System.out.println("Directory not found!");
                        break;
                    }
                    System.out.print("Enter the file name to add: ");
                    String newFileName = scanner.nextLine().trim();
                    dirForFile.addFile(newFileName);
                    System.out.println("File '" + newFileName + "' added to '" + dirPathForFile + "'");
                    break;

                case 2:
                    // Insert a new directory
                    System.out.print("Enter the directory path where you want to add a subdirectory (e.g., root/subDir2): ");
                    String dirPathForDir = scanner.nextLine().trim();
                    Directory dirForDir = findDirectoryByPath(root, dirPathForDir);
                    if (dirForDir == null) {
                        System.out.println("Directory not found!");
                        break;
                    }
                    System.out.print("Enter the new directory name: ");
                    String newDirName = scanner.nextLine().trim();
                    dirForDir.addDirectory(newDirName);
                    System.out.println("Directory '" + newDirName + "' added to '" + dirPathForDir + "'");
                    break;

                case 3:
                    // Print directory structure
                    root.printDirectoryStructure();
                    break;

                case 4:
                    // Search for a file
                    System.out.print("Enter the name of the file to search: ");
                    String searchFileName = scanner.nextLine().trim();
                    String filePath1 = root.findFile(searchFileName);
                    if (filePath1 != null) {
                        System.out.println("File found at: " + filePath1);
                    } else {
                        System.out.println("File not found.");
                    }
                    break;

                case 5:
                    // Get size of a directory
                    System.out.print("Enter the directory path to get size (e.g., root/subDir3): ");
                    String sizePath = scanner.nextLine().trim();
                    Directory dirForSize = findDirectoryByPath(root, sizePath);
                    if (dirForSize == null) {
                        System.out.println("Directory not found!");
                        break;
                    }
                    System.out.println("Total size of '" + sizePath + "': " + dirForSize.getSize());
                    break;

                case 6:
                    // Exit
                    exit = true;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option from the menu.");
                    break;
            }
        }



        scanner.close();


    }

    public static Directory findDirectoryByPath(Directory root, String path) {
        // If path is just "root", return root
        if (path.equals("root")) {
            return root;
        }

        String[] parts = path.split("/");
        // parts[0] should be "root"
        if (!parts[0].equals("root")) {
            return null; // Invalid path
        }

        Directory current = root;
        for (int i = 1; i < parts.length; i++) {
            String subDirName = parts[i];
            boolean found = false;
            for (Directory d : current.getD_children()) {
                if (d.getName().equals(subDirName)) {
                    current = d;
                    found = true;
                    break;
                }
            }

            if (!found) {
                // directory in the path doesn't exist
                return null;
            }
        }

        return current;
    }
}