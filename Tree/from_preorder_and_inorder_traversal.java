package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class from_preorder_and_inorder_traversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return  null;
        }

        int mid = -1;


        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                mid = i;
            }
        }

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,mid+1),Arrays.copyOfRange(inorder,0,mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length),Arrays.copyOfRange(inorder,
                mid+1 , inorder.length));

        return root;

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] pre_oder = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] in_order = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            TreeNode resulttree = buildTree(pre_oder,in_order);

            System.out.println(resulttree.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
