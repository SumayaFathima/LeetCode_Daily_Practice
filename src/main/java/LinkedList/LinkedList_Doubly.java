package LinkedList;

public class LinkedList_Doubly {

    Node head, tail, prev;
    int length;

    public void add(int input) {

        if (head == null) {
            Node temp = new Node(input);
            head = temp;
            tail = temp;
        }
        else {
            Node temp = new Node(input);
            Node temp2 = tail;
            tail.next = temp;
            tail = temp;
            tail.prev = temp2;
        }
        length++;
    }

    public int size() {

        return length;
    }
    public void print() {

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void removeFirst() {

        if(length ==1) head = tail = null;
        else
             head = head.next;
        length--;
        }

    public void removeIndex(int input) {


    }
}