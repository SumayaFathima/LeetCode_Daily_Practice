package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class S09_Palindrome_Linked_List {

    /* Leetcode_234 : https://leetcode.com/problems/palindrome-linked-list/

        Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

        Constraints:

            The number of nodes in the list is in the range [1, 10^5].
            0 <= Node.val <= 9
     */

    @Test
    public void example1() {
        int[] input = {1, 1, 2, 4, 3, 4, 5};
        Assert.assertEquals(palindrome(addAll(input)), false);
    }

    @Test
    public void example2() {
        int[] input = {1, 2, 2, 1};
        Assert.assertEquals(palindrome(addAll(input)), true);
    }

    @Test
    public void example3() {
        int[] input = {1};
        Assert.assertEquals(palindrome(addAll(input)), true);
    }

    @Test
    public void example4() {
        int[] input = {5, 6};
        Assert.assertEquals(palindrome(addAll(input)), false);
    }

    @Test
    public void example5() {
        int[] input = {1, 1, 3, 4, 1, 1};
        Assert.assertEquals(palindrome(addAll(input)), false);
    }

    @Test
    public void example6() {
        int[] input = {1,2,3,4,5,4,3,2,1};
       Assert.assertEquals(palindrome(addAll(input)), true);
      // palindrome(addAll(input));
    }

    //Time complexity : Bruteforce -
    //                  Optimized -

    /* Pseudo code :

        1. Calculate the length value for odd and even length
        2. Assign head to temp and traverse i<length and find previous and current value
        3. From that position do the reverse link. Traverse until current!=null
        4. head will be at first and previous will be at last
        5. Check each values and do head.next and previous.next until values are same and head == previous
        6. if values are not same return false

     */

    //TC : not sure
    ListNode head, tail;
    int length;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    private ListNode addAll(int[] input) {

        head = tail = null;
        length =0;

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

    public boolean palindrome(ListNode node) {

        if (head.val != tail.val) return false;
        if (head.next == null) return true;

        if (length % 2 == 0) length = length / 2;
        if (length % 2 == 1) length = (length + 1) / 2;

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        ListNode buddy = null;
        ListNode temp = head;

        for(int i=0; i<length; i++) {  //O(log(n))
            buddy = temp;
            temp = temp.next;
        }
        previous = buddy;
        current = temp;

        while(current!=null) {  //  O(log(n))

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        while (head != previous) {  //O(N)

            if (head.val == previous.val) {
                if (head.next == previous) return true;
                else {
                   head = head.next;
                   previous = previous.next;
                }
            }
            else
                return false;
        }
        return true;
    }
}


 /*    public boolean palindrome(ListNode node) {

        if (head.val != tail.val) return false;
        if (head.next == null) return true;

        ListNode temp = head;
        ListNode buddy = null;

        while (head != tail) {
                temp = head;
            if (head.val == tail.val) {
                if (head.next == tail) return true;
                while (temp.next != null) {
                    buddy = temp;
                    temp = temp.next;
                }
                buddy.next = null;
                tail = buddy;
                head = head.next;
                length = length - 2;
            } else
                return false;
        }
        return true;
    }
}  */

    /* Pseudo code :

   1.  Traverse while head != tail
   2.  Check if head value and tail value is equal, if no, return false
          - if yes traverse while temp.next != null
          - assign temp to dummy
          - and temp.next to next
   3. Then make buddy.next = null; and buddy to tail and head = head.next and length -2
   4. By default return true

     */


//Test case : 5min
//Pseudo code : 2hrs
//code : 1.5hrs
//optimized : 1hr