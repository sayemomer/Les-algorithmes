package linked_list;

import java.util.Arrays;
import java.util.Scanner;

public class odd_even_linked_list {

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int[] list = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ListNode head = ListNode.createList(list);

            ListNode result = oddEvenList(head);

            result.printList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
