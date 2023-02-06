package LinkedList;

import org.testng.annotations.Test;

public class S02_Merge_Two_Sorted_Lists {

    /* Leetcode_21 : https://leetcode.com/problems/merge-two-sorted-lists/

          You are given the heads of two sorted linked lists list1 and list2.
          Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
          Return the head of the merged linked list.

          Constraints:

            The number of nodes in both lists is in the range [0, 50].
            -100 <= Node.val <= 100
            Both list1 and list2 are sorted in non-decreasing order.
   */

    @Test
    public void example1() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        list.add(1, node1);
        list.add(2, node1);
        list.add(4, node1);

        ListNode node2 = new ListNode();
        list.add(1, node2);
        list.add(3, node2);
        list.add(4, node2);
        list.add(5, node2);

        list.mergeTwoLists(node1.head, node2.head);
    }

    @Test
    public void example2() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        list.add(1, node1);
        list.add(2, node1);
        list.add(4, node1);
        ListNode node2 = new ListNode();
        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    @Test
    public void example3() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.add(1, node2);
        list.add(3, node2);
        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    @Test
    public void example4() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        list.add(3, node1);
        ListNode node2 = new ListNode();
        list.add(2, node2);
        list.add(3, node2);
        list.add(4, node2);
        list.add(4, node2);
        list.add(5, node2);
        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    @Test
    public void example5() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        list.add(-2, node1);
        list.add(0, node1);
        list.add(2, node1);
        ListNode node2 = new ListNode();
        list.add(-1, node2);
        list.add(1, node2);
        list.add(3, node2);

        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    @Test
    public void example6() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    @Test
    public void example7() {

        S02_Merge_Two_Sorted_Lists list = new S02_Merge_Two_Sorted_Lists();

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode();
        list.add(0, node2);
        list.mergeTwoLists(node1.head, node2.head);
        //list.print(node3);
    }

    //TC : 0(N)

    /* Pseudo code :

        1. Traverse while node1 != null && node2 != null
        2. Check if node1 value <= node 2 value, then place node 1 in temp.next (which is of node 3) and do node1= node1.next;
        3. If node1 value > node 2 value, then place node 2 in temp.next and do node2= node2.next;
        4. Do temp = temp.next after the condition
        5. Do this until either node becomes null
        6. Then check if any 1 node has value then add that in temp.next
        7. Return node3.next

     */
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

        public ListNode(ListNode next) {
            this.next = next;
        }
    }

    public ListNode head=null;
    public ListNode tail=null;
    public int length=0;
    public ListNode node3;

    public ListNode add(int input, ListNode node) {

        ListNode temp = new ListNode(input);
        if (node.head == null) {
            node.head = temp;
            node.tail = temp;
        } else {
            node.tail.next = temp;
            node.tail = temp;
        }
        length++;
        return temp;
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        if(node1==null) return node2;
        if(node2==null) return node1;

        ListNode node3 = new ListNode();
        ListNode temp = node3;

        while (node1 != null && node2 != null) { //0(N)

            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next; }

            else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        if(node1!= null)    temp.next = node1;
        else temp.next = node2;

        return node3.next;
    }

    public void print(ListNode node) {

        ListNode temp = node;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
