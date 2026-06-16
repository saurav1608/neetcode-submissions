/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        //find middle point of the list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // At the end of the list slow is just behind the second part of the list
        // We need to reverse the second part of the linked linked list
        ListNode curr = slow.next;
        ListNode prev = slow.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //Merge the forward list and the reversed list
        ListNode forward = head;
        ListNode backward = prev;
        while (backward != null) {
            ListNode tmpForward = forward.next;
            ListNode tmpBackward = backward.next;
            forward.next = backward;
            backward.next = tmpForward;
            forward = tmpForward;
            backward = tmpBackward;
        } 
    }
}
