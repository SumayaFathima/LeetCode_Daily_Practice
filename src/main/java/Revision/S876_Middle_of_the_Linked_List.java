package Revision;

import LinkedList.S03_Linked_List_Cycle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S876_Middle_of_the_Linked_List {

    @Test
    public void example1() {
        int[] input = {1,2,3,4,5};
        for(int current : input) {
            add(current);
        }
        middleNode(head);
    }

    @Test
    public void example2() {
        int[] input = {1,2,3,4,5,6};
        for(int current : input) {
            add(current);
        }
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

        for(int i=0; i<length/2; i++) {
            head = head.next;
        }

        return head;
    }
}