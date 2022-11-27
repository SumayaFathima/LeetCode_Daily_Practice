package LinkedList;

public class LinkedList_Singly {

    Node head, tail;
    Node head1, head2;
    int length = 0;
    int count = 0;

    public void add(int input) {

        if (head == null) {
            Node temp = new Node(input);
            head = temp;
            tail = temp;
        } else {
            Node temp = new Node(input);
            tail.next = temp;
            tail = temp;
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

        if (length == 1) tail = head = null;
        else head = head.next;
        length--;
    }

    public void removeIndex(int input) {

        Node temp = head;
        Node dummy = null;

        for (int i = 0; i < input; i++) {
            dummy = temp;
            temp = temp.next;
        }
        dummy.next = temp.next;
    }

    public void removeValue(int input) {

        Node temp = head;
        Node dummy = null;

        while (temp.value != input) {
            dummy = temp;
            temp = temp.next;
        }
        dummy.next = temp.next;
    }

    public void set(int index, int value) {

        Node temp = head;
        Node dummy = null;
        Node newIndex = null;

        for (int i = 0; i < index; i++) {
            dummy = temp;
            temp = temp.next;
        }

        Node tt = new Node(value);
        newIndex = tt;

        newIndex.next = dummy.next;
        dummy.next = newIndex;
    }

    public void get(int index) {

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        System.out.println(temp.value);
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

    public int indexof(int input) {

        Node temp = head;
        length = -1;

        while (temp.next != null) {
            if (temp.value != input) {

                temp = temp.next;
                length++;
            } else {
                length++;
                temp = temp.next;
                count = length;

            }
        }

        return count;
    }

    //  public int lastindexof(int input) {


    //    return input;
    //  }

    public void removeLastIndex() {

        if (length == 1) tail = head = null;
        Node temp = head;
        Node buddy = null;

        while (temp.next != null) {
            buddy = temp;
            temp = temp.next;
        }

        buddy.next = null;
        length--;
    }

    public boolean pran(String s) {

        // LinkedList<Character> list = new LinkedList<>();

        Node temp = head;

        while (temp.next != null) {
            if (temp.value == '(' && temp.next.value == ')' || temp.value == '{' && temp.next.value == '}' || temp.value == '[' && temp.next.value == ']') {

                temp = temp.next;
            } else
                return false;
        }
        return true;
    }

    public void removeAll(int input) {

        Node temp = head;
        Node buddy = null;

        while (temp != null) {

            if (temp.value == input) {
                buddy.next = temp.next;
                temp = buddy.next;
            } else {
                buddy = temp;
                temp = temp.next;
            }
        }
    }

    public void addAll(int[] input) {

        for (int i : input) {

            if (head == null) {
                Node temp = new Node(i);
                head = temp;
                tail = temp;
            } else {
                Node temp = new Node(i);
                tail.next = temp;
                tail = temp;
            }
            length++;
        }
    }

    public boolean palindrome() {

        if (head.value != tail.value) return false;
        //Node buddy = null;

        while (head != null) {   //1 2 2 1
            if (head.value == tail.value) {

                Node temp = head;
                Node buddy = null;

                while (temp.next != null) {
                    buddy = temp;
                    temp = temp.next;
                }

                if(buddy.next.next ==null) {
                    buddy.next = null;
                    tail = buddy;
                    head = head.next;
                    length = length - 2;
                }
            }

            else
                return false;
        }

        System.out.println(length);
        if (length == 0) return true;
        return false;
    }


}


