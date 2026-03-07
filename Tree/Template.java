package Tree;

import java.util.Scanner;

public class Template {
        public static void main(String[] args) {
            try(Scanner sc = new Scanner(System.in)) {

                String[] tree = sc.nextLine().split(" ");

                TreeNode tree1 = TreeNode.insertLevelOrder(tree);

                System.out.println(tree1.toString());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
}
