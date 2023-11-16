package linked_list;

public class ListNode {

    public int val;
    public ListNode next;
    

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public void printList(){
        ListNode curr = this;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] arr){
        ListNode head = new ListNode();
        ListNode curr = head;
        for(int i = 0; i < arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head.next;
    }

    // public static void main(String[] args) {
    //     int[] arr = {1, 2, 3, 4};
    //     ListNode head = createList(arr);
    //     head.printList();
    // }

}
