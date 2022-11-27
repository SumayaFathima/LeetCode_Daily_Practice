package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class S03_Linked_List_Cycle {

    /* Leetcode_141 : https://leetcode.com/problems/linked-list-cycle/description/

    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
    the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to
    Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    Constraints:

        The number of the nodes in the list is in the range [0, 104].
        -105 <= Node.val <= 105
        pos is -1 or a valid index in the linked-list.
     */

    @Test
    public void example1() {
        int[] arr = {3,2,0,-4};
        Assert.assertEquals(hasCycle(addAll(arr)), true);
    }

    @Test
    public void example2() {
        int[] arr = {1,2};
        Assert.assertEquals(hasCycle(addAll(arr)), true);
    }

    @Test
    public void example3() {
        int[] arr = {1};
        Assert.assertEquals(hasCycle(addAll(arr)), false);
    }

    //TC : // O(N)
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
    public boolean hasCycle(ListNode head) { // O(N)

        if(head == null) return false;

        Set set = new HashSet();

        ListNode temp = head;

        while(temp.next !=null) {

            if(set.contains(temp.next)) return true;

            else
                set.add(temp.next);
            temp = temp.next;
        }

        return false;
    }
}
