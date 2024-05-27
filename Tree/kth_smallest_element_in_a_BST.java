package Tree;

import java.util.Scanner;
import java.util.Stack;

public class kth_smallest_element_in_a_BST {


    public static int kthSmallest(TreeNode root, int k) {

        int kthSmallest = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;  // Start with the root node
        int n = 0;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Current must be null at this point
            current = stack.pop();
            n++;
            if(n == k){
                kthSmallest = current.val;
                break;
            }
            
            
            // We have visited the node and its left subtree.
            // Now, it's right subtree's turn
            current = current.right;
        }

        return kthSmallest;
    }

        


    public static void main(String[] args) {


        try(Scanner sc = new Scanner(System.in)) {

            String[] nums = sc.nextLine().split(" ");
            int k = Integer.parseInt(sc.nextLine());

            TreeNode root = TreeNode.insertLevelOrder(nums);

            System.out.println(kthSmallest(root,k));
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
