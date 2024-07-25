package Tree;

import java.util.Scanner;

public class same_tree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p != null && q!= null && p.val == q.val){
            return isSameTree(p.left , q.left ) && isSameTree(p.right , q.right);
        }else {
            return false;
        }

    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] firstTree_s = sc.nextLine().split(" ");
            String[] secondTree_s = sc.nextLine().split(" ");

            TreeNode firstTree = TreeNode.insertLevelOrder(firstTree_s);
            TreeNode secondTree = TreeNode.insertLevelOrder(secondTree_s);

            System.out.println(isSameTree(firstTree,secondTree));



        }catch (Exception e){

        }
        
    }
    
}
