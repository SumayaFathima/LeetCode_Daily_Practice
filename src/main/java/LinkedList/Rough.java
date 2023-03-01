package LinkedList;

import org.testng.annotations.Test;

public class Rough {
    @Test
    public void example1() {
        int[] input = {1,2,3,4,5};
        middleNode(head);
    }
    ListNode head, tail;
    int length;
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void add(int input) {

        if(head == null) {
            ListNode temp = new ListNode(input);
            head = temp;
            tail = temp;
        }

        else {
            ListNode temp = new ListNode(input);
            tail.next = temp;
            tail = temp;
        }
        length++;
    }
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        if(fast.next != null){
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }
}