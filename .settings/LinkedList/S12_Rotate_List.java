package LinkedList;

import org.testng.annotations.Test;

public class S12_Rotate_List {

    /* Leetcode_61 : https://leetcode.com/problems/rotate-list/

        Given the head of a linked list, rotate the list to the right by k places.

        Constraints:

            The number of nodes in the list is in the range [0, 500].
            -100 <= Node.val <= 100
            0 <= k <= 2 * 10^9
     */

    @Test
    public void example1() {   //45123
        int[] input = {1,2,3,4,5};
        int k =2;
        rotateRight(addAll(input), k);
    }

    @Test
    public void example2() {   //201
        int[] input = {0,1,2};
        int k =4;
        rotateRight(addAll(input), k);
    }
    @Test
    public void example3() { //7,0,10,6,7,-1,4,5,-2,6
        int[] input = {-1,4,5,-2,6,7,0,10,6,7};
        int k = 5;
        rotateRight(addAll(input), k);
    }
    @Test
    public void example4() { //-4,-5,-1,-2,-3
        int[] input = {-1,-2,-3,-4,-5};
        int k =10;
        rotateRight(addAll(input), k);
    }

    /* Pseudo code:

       1. Find length to which it should traverse
		       - if(k>length) length  = k%length;
               - if(k<length)  length = length-k-1;
       2. Traverse till i< length and make buddy.next as last node and make buddy.next as null;
       3. Find the tail of the last node to make temp.next as current
       4. Return last

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

    public ListNode rotateRight(ListNode head, int k) {

        ListNode current = head;
        ListNode previous = null;
        ListNode buddy = null;
        buddy = current;

        if(k>length) length  = k%length;
        if(k<length)  length = length-k-1;


        for (int i = 0; i < length; i++) {
            buddy = buddy.next;
        }
        ListNode last = buddy.next;
        buddy.next = null;

        ListNode temp = last;
        while(temp.next !=null) {
            temp = temp.next;
        }

        temp.next = current;

        return last;
    }
}

//Test case : 5min
//Pseudo code : 30min
//code : 1hr
