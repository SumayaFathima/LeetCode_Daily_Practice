package LinkedList;

public class S13_Design_HashSet {

        Node head;
        class Node {
            int val;
            Node next;

            public Node(int key) {
                this.val = key;
                this.next = null;
            }
        }

        public S13_Design_HashSet() {
            head = null;
        }

        public void add(int key) {

            if(head==null) {
                head = new Node(key);
                return;
            }

            boolean keyispresent = contains(key);

            if(!keyispresent) {
                Node temp = head;

                while(temp.next != null) {
                    temp = temp.next;
                }

                temp.next = new Node(key);
            }
        }

        public void remove(int key) {

            if(head==null) return;

            if(head.val == key) {
                head = head.next;
                return;
            }

            Node temp=head;

            while(temp.next!=null) {
                if(temp.next.val == key) {
                    temp.next = temp.next.next;
                }
                else
                    temp=temp.next;
            }

        }

        public boolean contains(int key) {

            if(head==null) return false;

            if(head.val == key) return true;

            Node temp = head;

            while(temp.next!=null) {

                if(temp.next.val == key) return true;
                else
                    temp = temp.next;
            }
            return false;
        }
    }