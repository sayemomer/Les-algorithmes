package linked_list;

import java.util.Scanner;

public class reorder_list {

    public static void reorderList(ListNode head) {

        //ok lets print the list first for future debugging needs

        //1 2 3 4
        //1 2 3 4 5

        //for this list to be reorder like the problem statement said,1st we have a middle point to
        //split the list, which we can do using first and slow pointer

        ListNode slow_pointer = head;
        ListNode fast_pointer = head.next;

        while (fast_pointer != null && fast_pointer.next !=null ) {

            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;

        }

        //so our second portion which we need to reverse is stats from here
        //so the next element will be the head of our second list

        ListNode second = slow_pointer.next;
        ListNode prev = null;
        slow_pointer.next = null;

        // now we have to reverse this half

        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
            
        }

        //now we have to merge the two list
        ListNode first = head;

        while (prev != null) {
            // now we need two temp
            //one for the next of 1st half
            //one for the next of 2nd half

            // 1 2
            // 4 3

            ListNode temp1 = first.next;
            ListNode temp2 = prev.next;

            first.next = prev;
            prev.next = temp1;
            first = temp1;
            prev = temp2;

        }

        head.printList();

    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            String[] nums_s = sc.nextLine().split(" ");
            int[] nums = new int[nums_s.length];

            for (int i = 0; i < nums_s.length; i++) {
                nums[i] = Integer.parseInt(nums_s[i]);  
            }

            ListNode head = ListNode.createList(nums);

            reorderList(head);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
