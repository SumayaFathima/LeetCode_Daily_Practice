package LinkedList;

import org.testng.annotations.Test;

public class S01_RemoveDuplicatesFromSortedList {

    @Test
    public void example1() {
        int[] input = {1,1,2,4,3,4,5};
        for(int curr : input) {
            add(curr);
        }
        removeDuplicates();
        print();
    }

    Node head, tail;
    int length =0;

    public class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public void add(int input) {

        if(head == null) {
            Node temp = new Node(input);
            head = temp;
            tail = temp;
        }

        else {
            Node temp = new Node(input);
            tail.next = temp;
            tail = temp;
        }
        length++;
    }

    public void removeDuplicates() {

        Node temp = head;
        tail = temp.next;

        while (tail != null) {

            if (temp.value == tail.value) {

                temp.next = tail.next;
                tail = tail.next;
            } else {
                tail = tail.next;
                temp = temp.next;
            }
        }
    }

    public void print() {

        Node temp = head;

        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
