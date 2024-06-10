class Node:
  def __init__(self, val):
    self.val = val
    self.next = None

class LinkedList:
  def __init__(self):
    self.head = None
  
  def print_list(self):
    cur_node = self.head
    while cur_node:
      print(cur_node.val)
      cur_node = cur_node.next

  def print_cyclelist(self,pos):

      cycleNode = self.head
      currentNode = self.head

      for _ in range(pos):
          cycleNode = cycleNode.next
      
      while currentNode:
          print(currentNode.val)
          currentNode = currentNode.next
          if currentNode.next == cycleNode:
             print(currentNode.val)
             break

    
  def createCycle(self,pos):

        currentNode = self.head
        cycleNode = self.head

        for _ in range(pos):
          cycleNode = cycleNode.next

        while currentNode:
            if currentNode.next == None:
                break
            currentNode = currentNode.next
        currentNode.next = cycleNode

  def append(self, val):
    new_node = Node(val)
    if self.head is None:
      self.head = new_node
      return
    last_node = self.head
    while last_node.next:
      last_node = last_node.next
    last_node.next = new_node

  def bulkLoad(self,arr):
    for i in arr:
      self.append(i)

  
# llist = LinkedList()
# # llist.append(3)
# # llist.append(2)
# # llist.append(0)
# # llist.append(-4)

# llist.bulkLoad([3,2,0,-4,-4])

# # llist.print_list()
# # llist.createCycle(1)
# # llist.print_cyclelist(1)
# print(llist.hasCycle())