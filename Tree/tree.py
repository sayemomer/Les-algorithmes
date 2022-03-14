class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class BinaryTree(object):
    def __init__(self, root):
        self.root = Node(root)

    def print_tree(self,tree, traversal_type):
        if traversal_type == "preorder":
            return self.preorder_print(tree.root, "")
        elif traversal_type == "inorder":
            return self.inorder_print(tree.root, "")
        elif traversal_type == "postorder":
            return self.postorder_print(tree.root, "")
        elif traversal_type == "levelorder":
            return self.levelorder_print(tree.root,"")

        else:
            print("Traversal type " + str(traversal_type) + " is not supported.")
            return False

    def preorder_print(self, start, traversal):
        """Root->Left->Right"""
        if start:
            traversal += (str(start.val) + "-")
            traversal = self.preorder_print(start.left, traversal)
            traversal = self.preorder_print(start.right, traversal)
        return traversal

    def inorder_print(self, start, traversal):
        """Left->Root->Right"""
        if start:
            traversal = self.inorder_print(start.left, traversal)
            traversal += (str(start.val) + "-")
            traversal = self.inorder_print(start.right, traversal)
        return traversal

    def postorder_print(self, start, traversal):
        """Left->Right->Root"""
        if start:
            traversal = self.postorder_print(start.left, traversal)
            traversal = self.postorder_print(start.right, traversal)
            traversal += (str(start.val) + "-")
        return traversal

    def levelorder_print(self, start,traversal):
        if start is None:
            return 

        queue = []
        queue.append(start)

        traversal = []
        while len(queue):
            x=[]
            for _ in range(len(queue)):
                node = queue.pop(0)
                x.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            traversal.append(x)

        return traversal

# 1-Null-2-3
# 4-2-5-1-6-3-7
# 4-5-2-6-7-3-1
#               3
#             /   \  
#            9     20
#           /       \
#          4         7


# Set up tree:
# tree = BinaryTree(3)
# tree.root.left = Node(9)
# tree.root.right = Node(20)
# tree.root.left.left = Node(4)
# # tree.root.left.right = Node(5)
# # tree.root.right.left = Node(15)
# tree.root.right.right = Node(7)

# print(tree.print_tree("preorder"))
# print(tree.print_tree("inorder"))
# print(tree.print_tree("postorder"))
# print(tree.print_tree("levelorder"))