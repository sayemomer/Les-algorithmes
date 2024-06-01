package Tree;

import java.util.Scanner;
import java.util.Stack;

public class validate_binary_search_tree {


    public static boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
           while (root != null) {
            System.out.println("pushing" + root.val);
              stack.push(root);
              root = root.left;
           }

           
           root = stack.pop();
           System.out.println("popped" + root.val);
           System.out.println("pre" + pre);
           if(pre!=null){
            System.out.println("pre" + pre.val);
           }
           
           if(pre != null && root.val <= pre.val) return false;
           pre = root;
           root = root.right;
        }
        return true;
        
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] nums = sc.nextLine().split(" ");

            TreeNode rooNode = TreeNode.insertLevelOrder(nums);


            System.out.println(isValidBST(rooNode));


            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
