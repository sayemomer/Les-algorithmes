# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from list import LinkedList
class Solution:
    def deleteDuplicates(self, list):


        ht = dict()
        curr = list.head
        prev = None

        while curr:
            if curr.val in ht:
                prev.next = curr.next
                ht[curr.val]+=1
            else:
                prev = curr
                ht[curr.val]=1
            curr= curr.next
        return list


llist = LinkedList()
# llist.bulkLoad([1,1,2])
# llist.bulkLoad([1,1,2,3,3])
llist.bulkLoad([1])
# llist.print_list()

ss = Solution()
result = ss.deleteDuplicates(llist)
print(result.print_list())


        