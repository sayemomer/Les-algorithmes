package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class Validate_a_Binary_Search_Tree {

    public static boolean dfs(TreeNode root,Double left , Double right){

        if(root == null){
            return true;
        }

        if(! (root.val > left && root.val < right)){
            return false;
        }

        return dfs(root.left,left, (double) root.val) &&
                dfs(root.right,(double) root.val,right);

    }

    public static boolean isValidBST(TreeNode root) {

        return  dfs(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] nums =sc.nextLine().split(" ");

            TreeNode root = TreeNode.insertLevelOrder(nums);

            System.out.println(isValidBST(root));

        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
