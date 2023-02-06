package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class S10_Reverse_Linked_List {

    /* Leetcode:206 :  https://leetcode.com/problems/reverse-linked-list/

        Given the head of a singly linked list, reverse the list, and return the reversed list.

        Constraints:

            The number of nodes in the list is the range [0, 5000].
            -5000 <= Node.val <= 5000

     */

    @Test
    public void example1() {
        int[] input = {1, 2, 3, 4, 5};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    @Test
    public void example2() {
        int[] input = {1, 2};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    @Test
    public void example3() {
        int[] input = {};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    @Test
    public void example4() {
        int[] input = {-1, -2, 3, -4, 5, -6, 9, 1, 14, 5000, 0, 7};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    @Test
    public void example5() {
        int[] input = {5000};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    @Test
    public void example6() {
        int[] input = {-1, 0, 1};
        //Assert.assertEquals(reverseList(addAll(input)), output);
        reverseList(addAll(input));
        //print();
    }

    //Time complexity : O(N)

    /* Pseudo code :

        1. Create Listnodes  current = head, previous = null, ListNode next = null;
        2. Traverse while current != null
        3. To make connection of the current value with the previous value,
                    - Make next = current.next;
                    - current.next = previous;
                    - previous = current;
                    - current = next;
        4. Once current == null, return previous
     */


    ListNode head, tail;
    int length = 0;

    public class ListNode {
        public int val;
        public ListNode tail;
        public ListNode head;
        public ListNode temp;
        public ListNode next;
        int length;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode() {
            head = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addAll(int[] input) {

        head = tail = null;

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

    public ListNode reverseList(ListNode head) { //O(N)

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void print(ListNode previous) {

        while (previous.next != null) {
            System.out.println(previous.val);
            previous = previous.next;
        }
    }
}

//Test case : 5min
//Pseudo code : 2hrs
//code : 1.5hrs