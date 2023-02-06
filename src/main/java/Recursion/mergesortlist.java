package Recursion;

import org.testng.annotations.Test;

public class mergesortlist {

    @Test
    public void example1() {

        mergesortlist list = new mergesortlist();

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

    public ListNode head = null;
    public ListNode tail = null;
    public int length = 0;
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

        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode node3 = new ListNode();
        return recursion(node1, node2, node3);

    }

    public ListNode recursion(ListNode node1, ListNode node2, ListNode node3) {

        ListNode temp = node3;

        if (node1 == null && node2 == null) return node3.next;

        if (node1.val <= node2.val) {
            temp.next = node1;
            node1 = node1.next;
        } else {
            temp.next = node2;
            node2 = node2.next;
        }
        temp = temp.next;

        if (node1 != null)
            temp.next = node1;
        else temp.next = node2;

        recursion(node1, node2, node3);

        return node3.next;
    }
}