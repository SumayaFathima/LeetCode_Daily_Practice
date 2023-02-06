package LinkedList;

   public class ListNode {

        public int val;

        public ListNode tail;
        public ListNode head;
        public ListNode temp;
        public ListNode next;
        public ListNode prev;


       int length;

        public ListNode(int val) {

            this.val = val;
            next = null;
            prev = null;
        }

        public ListNode() {
            head = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
