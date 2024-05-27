package Tree;

import java.util.Scanner;

public class lowest_common_ancestor_of_a_binary_search_tree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        root.inOrderTraversal();

        while (curr!= null) {

            if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }else if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }else{
                 break;
            }
            
        }

        return curr;
        
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            String[] nums_s = sc.nextLine().split(" ");
            int p_value = Integer.parseInt(sc.nextLine());
            int q_value =  Integer.parseInt(sc.nextLine());

            TreeNode root = TreeNode.insertLevelOrder(nums_s);

            TreeNode p = root.find(p_value);
            TreeNode q = root.find(q_value);

            System.out.println(lowestCommonAncestor(root,p,q));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
