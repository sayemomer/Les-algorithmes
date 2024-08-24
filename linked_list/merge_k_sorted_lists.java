package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class merge_k_sorted_lists {


    public static ListNode mergeKLists(ListNode[] lists) {

        //so here our problem is instead of two separate linkedList we have one
        //form this one we need to create two and merge those two

        if (lists.length == 0 ){
            return null;
        }

        ListNode node1 ;
        ListNode node2;

        while (lists.length >1){

            ArrayList<ListNode> merged_list = new ArrayList<>();

            for (int i = 0; i < lists.length; i=i+2) {
                node1 = lists[i];

                if( (i+1) < lists.length ){
                    node2 = lists[i+1];
                }else{
                    node2 = null;
                }

                merged_list.add(merge_two_list(node1,node2));
            }
            lists = merged_list.toArray(new ListNode[0]);

        }



        return lists[0];

    }


    public static ListNode merge_two_list(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        //1->4->5
        //3->5
//
//        l1.printList();
//        l2.printList();

        while (l1 != null && l2!= null){

            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;

        }

        if (l1!= null){
            tail.next = l1;
        }
        if (l2!=null) {
            tail.next = l2;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            int row;

            row = Integer.parseInt(sc.nextLine());

            ListNode[] k_sorted_list = new ListNode[row];


            for (int i = 0; i < k_sorted_list.length; i++) {

                int[] list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                ListNode e = ListNode.createList(list);
                k_sorted_list[i] = e;

            }

            System.out.println("Before merging...");

            for (int i = 0; i < k_sorted_list.length; i++) {

                k_sorted_list[i].printList();

            }

            System.out.println();

            System.out.println("After merging...");

            ListNode list = mergeKLists(k_sorted_list);
            list.printList();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
