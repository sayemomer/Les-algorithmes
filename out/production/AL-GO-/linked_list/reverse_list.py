from list import LinkedList
class Solution:
    def reverseList(self, list):
        prevItem = None
        currentItem = list.head
        while currentItem:
            nxt = currentItem.next
            currentItem.next = prevItem
            prevItem = currentItem
            currentItem = nxt
        list.head = prevItem

        return list

llist = LinkedList()
# llist.bulkLoad([1,2,3,4,5])
# llist.bulkLoad([1,2])
llist.bulkLoad([])

ss = Solution()
result = ss.reverseList(llist)
print(result.print_list())