package linked_list;

import java.util.Arrays;
import java.util.Scanner;

public class remove_from_nth_node {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //first need to get the length of the list

        ListNode curr = head;
        int length = 0;

        while (curr != null){
            length++;
            curr = curr.next;
        }

        curr = head;

//        System.out.println(length);

        for (int i = 0; i < (length - n) -1; i++) {
            curr = curr.next;
        }

        if(curr.next != null && (length - n)!=0){
            curr.next = curr.next.next;
        }else {
            return head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int[] list = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = Integer.parseInt(sc.nextLine());

            ListNode head = ListNode.createList(list);

            ListNode result = removeNthFromEnd(head,n);

            result.printList();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
