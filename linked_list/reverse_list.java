package linked_list;

public class reverse_list {

    public static void reverse(ListNode head){


        //1->2->3->4->null
        //4->3->2->2->null

        // null <- 1 <- 2 <-3 <-4

    ListNode curr = head;
    ListNode prev = null;

    while (curr!=null) {

        ListNode next = curr.next;

        curr.next = prev;
        prev = curr;

        //this one I need to loop through
        curr = next;

    }

    head = prev;

    head.printList();

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5};
        ListNode head = ListNode.createList(arr);
        reverse(head);
    }
    
}
