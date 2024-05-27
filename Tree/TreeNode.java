package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a new node
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    // Method to insert values in the binary search tree
    public void insert(int value) {
        if (value < val) {
            if (left != null) {
                left.insert(value);
            } else {
                left = new TreeNode(value);
            }
        } else if (value > val) {
            if (right != null) {
                right.insert(value);
            } else {
                right = new TreeNode(value);
            }
        }
    }

    public static TreeNode insertLevelOrder(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(values[i++]));
        queue.offer(root);

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Process the left child
            if (i < values.length && !values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            // Process the right child
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Method to search for a value in the binary search tree
    public boolean contains(int value) {
        if (value == val) {
            return true;
        } else if (value < val) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    // Method to perform an in-order traversal of the binary search tree
    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }
        System.out.print(val + " ");
        if (right != null) {
            right.inOrderTraversal();
        }
    }

    // Method to find the minimum value in the binary search tree
    public int findMin() {
        if (left == null) {
            return val;
        } else {
            return left.findMin();
        }
    }

    // Method to find the maximum value in the binary search tree
    public int findMax() {
        if (right == null) {
            return val;
        } else {
            return right.findMax();
        }
    }

     // Method to find a node in the BST
     public TreeNode find(int value) {
        if (value == this.val) {
            return this;
        } else if (value < this.val) {
            return this.left == null ? null : this.left.find(value);
        } else {
            return this.right == null ? null : this.right.find(value);
        }
    }
}

