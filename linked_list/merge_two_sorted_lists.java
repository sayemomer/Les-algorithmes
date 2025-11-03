package linked_list;

import java.util.Scanner;

public class merge_two_sorted_lists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //create a dummy node
        ListNode newList = new ListNode();

        ListNode curr = newList;

        while (list1 != null && list2 !=null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if(list1 != null){
            curr.next = list1;
        }else {
            curr.next = list2;
        }

        return newList;
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int[] arr1 = {1,2,4};
            ListNode head1 = ListNode.createList(arr1);
            int[] arr2 = {1,3,4};
            ListNode head2 = ListNode.createList(arr2);

            System.out.println(mergeTwoLists(head1,head2));



        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
