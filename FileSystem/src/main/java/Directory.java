/**
 * Name and ID: Omer Sayem, 40226505
 * Assignments 3
 * Due Date: 30 november 2024
 */


import java.util.ArrayList;
import java.util.List;

/**
 * represents directories and files
 */

public class Directory {

    private String d_name;

    private boolean d_isFile;

    private List<Directory> d_children;

    /**
     * Constructor that take file or directory name and flag
     * @param p_name
     * @param p_isFile
     */

    Directory(String p_name , boolean p_isFile){
        d_name = p_name;
        d_isFile = p_isFile;
        if (!d_isFile) {
            this.d_children = new ArrayList<>(); // Initialize the list for directories
        }
    }

    /**
     * Add file into the dictionary
     * @param fileName
     */
    public void addFile(String fileName) {
        if (!this.d_isFile) {
            this.d_children.add(new Directory(fileName, true));
        } else {
            System.out.println("Error adding file");
        }
    }

    /**
     * Add file into the dictionary
     * @param dirName
     */
    public void addDirectory(String dirName) {
        if (!this.d_isFile) {
            this.d_children.add(new Directory(dirName, false));
        } else {
            System.out.println("Cannot add a directory to a file!");
        }
    }

    /**
     * Recursively print directory structure
     * if its a directory do recursive call
     * @param root
     */
    public void printDirectoryStructure(String root) {
        System.out.println(root + d_name );
        if (!d_isFile) {
            if ( d_children.isEmpty() ) {
                System.out.println(root + "  (empty)");
            } else {
                for (Directory child : d_children) {
                    child.printDirectoryStructure(root + "  ");
                }
            }
        }
    }

    /**
     * init call of print directory from  root
     */
    public void printDirectoryStructure() {
        printDirectoryStructure("");
    }

    /**
     * get the size of the whole directory
     * @return size of the folder
     */
    public int getSize() {
        if (this.d_isFile) {
            return 1;
        }
        int size = 0;
        for (Directory child : d_children) {
            size += child.getSize();
        }
        return size;
    }

    /**
     * Recursively Search for a file
     * @param fileName
     * @param currentPath
     * @return
     */
    public String findFile(String fileName, String currentPath) {
        if (this.d_isFile && this.d_name.equals(fileName)) {
            return currentPath + "/" + this.d_name;
        }

        if (!this.d_isFile) {
            for (Directory child : this.d_children) {
                String foundPath = child.findFile(fileName, currentPath + "/" + this.d_name);
                if (foundPath != null) {
                    return foundPath;
                }
            }
        }
        return null; // file is not found
    }

    /**
     * Init call to find a file
     * @param fileName
     * @return
     */

    public String findFile(String fileName) {
        return findFile(fileName, "");
    }


    /**
     * getChildren
     */

    public List<Directory> getD_children(){
        return this.d_children;
    }

    public String getName() {
        return d_name;
    }
}
