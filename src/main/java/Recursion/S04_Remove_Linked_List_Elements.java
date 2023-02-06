package Recursion;


import org.testng.Assert;
import org.testng.annotations.Test;

public class S04_Remove_Linked_List_Elements {

    //https://leetcode.com/problems/remove-linked-list-elements/description/

    @Test
    public void example1() {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        int[] output = {1, 2, 3, 4, 5};
        Assert.assertEquals(addAll(arr), output);
    }

    @Test
    public void example2() {

        int[] arr = {6,6,6,6,6,6};
        int val = 6;
        int[] output = {};
        Assert.assertEquals(addAll(arr), output);
    }

    @Test
    public void example3() {

        int[] arr = {1, 2, 6};
        int val = 0;
        int[] output = {1,2,6};
        Assert.assertEquals(addAll(arr), output);
    }

    @Test
    public void example4() {

        int[] arr = {};
        int val = 6;
        int[] output = {};
        Assert.assertEquals(addAll(arr), output);
    }

    /* Pseudo code :

       1. if head has the given val, then make head as head.next -> continue until head is same as val
       2. call recursion with head and val
       3. create temp node as head
       4. traverse while temp != null and temp.next != null
       5. if temp.next.val is equal to val then temp.next = temp.next.next
       6. else temp = temp.next
       7. return head


     */
    ListNode head, tail;
    int length;

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
            head = null;
        }

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode addAll(int[] input) {

        head = tail = null;
        length = 0;

        for (int i : input) {

            if (head == null) {
                ListNode temp = new ListNode(i);
                head = temp;
                tail = temp;
            } else {
                ListNode temp = new ListNode(i);
                tail.next = temp;
                tail = temp;
            }
            length++;
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head== null) return head;
        while (head != null && head.val == val)
            head = head.next;

        ListNode temp = head;
        return recursion(head,val, temp);
    }

    public ListNode recursion(ListNode head, int val, ListNode temp) {

        if(temp != null && temp.next != null) return head;

            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else temp = temp.next;

            recursion(head, val, temp);
            return head;
    }
}