from tree import BinaryTree,Node

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root) -> bool:
        if root is None:
            return True
        elif root.left is None and root.right is None:
            return True
        elif root.left is None or root.right is None:
            if root.left:
                if root.left.val >= root.val:
                    return False
                else:
                    return True
            if root.right:
                if root.right.val <= root.val:
                    return False
                else:
                    return True
        elif not root.left.val < root.val or not root.right.val > root.val:
            return False
        else:
            return self.isValidBST(root.left) and self.isValidBST(root.right)

#               2
#             /   \  
#            1     3
#                 
#      
# Set up tree:
# tree = BinaryTree(2)
# tree.root.left = Node(1)
# tree.root.right = Node(3)             


#               5
#             /   \  
#            1     4
#                 /  \   
#                3    6

# # Set up tree:
# tree = BinaryTree(5)
# tree.root.left = Node(1)
# tree.root.right = Node(4)
# # tree.root.left.left = Node(4)
# # # tree.root.left.right = Node(5)
# tree.root.right.left = Node(3)
# tree.root.right.right = Node(6)

#               1
#             /   \  
#                  1
#                   
#                
# # Set up tree:
# tree = BinaryTree(1)
# # tree.root.left = Node(1)
# tree.root.right = Node(1)
# # tree.root.left.left = Node(4)
# # # # tree.root.left.right = Node(5)
# # tree.root.right.left = Node(3)
# # tree.root.right.right = Node(6)


tree = BinaryTree(0)
tree.root.left = Node(-1)
# tree.root.right = Node(1)
# tree.root.left.left = Node(4)
# # # tree.root.left.right = Node(5)
# tree.root.right.left = Node(3)
# tree.root.right.right = Node(6)

# print(tree.print_tree("preorder"))
# print(tree.print_tree("inorder"))
# print(tree.print_tree("postorder"))
# print(tree.print_tree(tree,"levelorder"))
SS = Solution()
result = SS.isValidBST(tree.root)
print(result)
