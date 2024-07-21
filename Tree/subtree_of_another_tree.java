package Tree;

import java.util.Scanner;

public class subtree_of_another_tree {


    public static boolean same_tree(TreeNode root,TreeNode subRoot){
        //base case
        if(root == null && subRoot == null){
            return true;
        }
        if(root!= null && subRoot!= null && root.val == subRoot.val){
            return same_tree(root.left,subRoot.left) && same_tree(root.right , subRoot.right);
        }else {
            return false;
        }
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null){
            return false;
        }

        if(subRoot == null){
            return true;
        }

        if(same_tree(root,subRoot)){
            return true;
        }else {
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] nums1 = sc.nextLine().split(" ");
            String[] nums2 = sc.nextLine().split(" ");

            TreeNode root = TreeNode.insertLevelOrder(nums1);
            TreeNode subRoot = TreeNode.insertLevelOrder(nums2);

            System.out.println(isSubtree(root,subRoot));


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
