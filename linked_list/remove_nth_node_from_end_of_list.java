package linked_list;

import java.util.LinkedList;
import java.util.Scanner;

public class remove_nth_node_from_end_of_list {

    public static ListNode removeNthFromEnd(ListNode head, int n) {


        //let the slow pointer to be this

        ListNode dummy_pointer = new ListNode(0,head);
    
        ListNode slow_pointer = dummy_pointer;

        ListNode fast_pointer = head;
        
        //so ther fast_pointer would be the n steps ahead of slow_pointer

        while (fast_pointer!= null && n>0) {

            fast_pointer = fast_pointer.next;
            n--;
            
        }

        // System.out.println(fast_pointer.val);

        while (fast_pointer!= null ) {

            slow_pointer= slow_pointer.next;
            fast_pointer = fast_pointer.next;
            
        }
        //now we are gonna set the next pointer of this is the fast pointer

        slow_pointer.next = slow_pointer.next.next;

        return dummy_pointer.next;
        
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String[] nums_s = sc.nextLine().split(" ");
            int n = Integer.parseInt(sc.nextLine());
            int[] nums = new int[nums_s.length];

            for (int i = 0; i < nums_s.length; i++) {
                nums[i] = Integer.parseInt(nums_s[i]);
            }

            ListNode head = ListNode.createList(nums);

            

            ListNode result_head = removeNthFromEnd(head,n);

            result_head.printList();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
