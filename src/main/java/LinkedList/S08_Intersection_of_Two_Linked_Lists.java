package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S08_Intersection_of_Two_Linked_Lists {

    @Test
    public void example1() {
        int[] listA  = {4,1,8,4,5};
        int[] listB  = {5,6,1,8,4,5};
        Assert.assertEquals(getIntersectionNode(listA, listB), false);
    }

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
       public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        return headA;
    }
}
