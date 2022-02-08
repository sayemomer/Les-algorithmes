from list import LinkedList

class Solution:
    def hasCycle(self, head) -> bool:
        slow = head
        fast = head
        while slow and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False
  
llist = LinkedList()
llist.bulkLoad([3,2,0,-4,-4])

llist.print_list()
# llist.createCycle(1)


ss = Solution()
result = ss.hasCycle(llist.head)
# llist.print_cyclelist(1)
print(result)