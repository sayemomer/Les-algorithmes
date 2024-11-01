package linked_list;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode cycleNode;
    

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
    }

    public void printCycleList(int len){

        ListNode curr = this;
        while(curr != null && len>=0){
            System.out.print(curr.val + " ");
            curr = curr.next;
            len--;
        }

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

    //create a list with a cycle
    public static ListNode createCycleList(int[] arr, int pos){
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode cycleNode = null;
        for(int i = 0; i < arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
            if(i == pos){
                cycleNode = curr;
            }
        }
        curr.next = cycleNode;
        return head.next;
    }

//    public static void main(String[] args) {
//        //create list with cycle
//
//    }

}
