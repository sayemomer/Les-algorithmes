package Tree;

import java.util.Scanner;

public class invert_binary_tree {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] tree = sc.nextLine().split(" ");

            TreeNode tree1 = TreeNode.insertLevelOrder(tree);

            tree1 = invertTree(tree1);

            System.out.println(tree1.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
