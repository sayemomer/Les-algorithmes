from unittest import result
from list import LinkedList


class Solution:
    def mergeTwoLists(self, list1, list2):
        # x = list1.head
        # y=list2.head

        # while x or y:
        #     print(x.val)
        #     print(y.val)

        #     x = x.next
        #     y= y.next
        p = list1.head 
        q = list2.head
        s = None

        if not p:
            return q
        if not q:
            return p

        if p and q:
            if p.val <= q.val:
                s = p 
                p = s.next
            else:
                s = q
                q = s.next
            new_head = s 
        while p and q:
            if p.val <= q.val:
                s.next = p 
                s = p 
                p = s.next
            else:
                s.next = q
                s = q
                q = s.next
        if not p:
            s.next = q 
        if not q:
            s.next = p

        list1.head = new_head     
        return list1



llist1 = LinkedList()
llist1.bulkLoad([1])

llist2 = LinkedList()
llist2.bulkLoad([2])

ss = Solution()
result = ss.mergeTwoLists(llist1,llist2)
print(result.print_list())


