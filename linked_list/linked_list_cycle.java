package linked_list;

import java.util.Scanner;

import Binary_search.find_minimum_in_rotated_sorted_array;

public class linked_list_cycle {

    public static boolean hasCycle(ListNode head) {

        boolean has_cycle = false;


        ListNode fast_pointer = head;
        ListNode slow_pointer = head;

        while (fast_pointer != null && slow_pointer !=null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;

            if(fast_pointer == slow_pointer){
                has_cycle = true;
                break;
            }
        }

        return has_cycle;

    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {


            String[] nums_sc = sc.nextLine().split(" ");
            int[] nums = new int[nums_sc.length];
            int pos = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < nums_sc.length; i++) {
                nums[i] = Integer.parseInt(nums_sc[i]);
            }
            ListNode head = ListNode.createCycleList(nums, pos);
            System.out.println(hasCycle(head));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
