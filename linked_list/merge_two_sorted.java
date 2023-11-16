package linked_list;

/**
 * mergei_two_sorted
 */
public class merge_two_sorted {

    public static void merge(ListNode list1, ListNode list2){

        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;

        while (list1 != null && list2!= null) {

            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
            
        }

        if(list1 != null){
            curr.next = list1;
        }else{
            curr.next = list2;
        }

        mergedList.next.printList();

    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,4};
        ListNode head1 = ListNode.createList(arr1);
        int[] arr2 = {1,3,4};
        ListNode head2 = ListNode.createList(arr2);

        merge(head1, head2);
        
        
        
    }
    
}