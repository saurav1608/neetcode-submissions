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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reversePartialList(head, left, right);
    }

    public ListNode reversePartialList(ListNode head, int left, int right) {

        //Initialize a dummy node 
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // Track a pointer starting at dummy node
        ListNode trailingTracker = dummy;
        //Track a pointer starting at head
        ListNode reversalPointer = head;

        //Move the reversal pointer and trailing pointer till it reaches the point where reversal has to start
        for (int i = 1; i < left; i++) {
            trailingTracker = trailingTracker.next;
            reversalPointer = reversalPointer.next;
        }

        
        //Start reversing, steps to reverse would be right-left+1
        //Initialize a null node
        ListNode prev = null;
        for (int i = 1; i <= (right - left) + 1; i++) {
            ListNode temp = reversalPointer.next;
            reversalPointer.next = prev;
            prev = reversalPointer;
            reversalPointer = temp;
        }

        //Removing the dangling null and attach it to where reversalPointer is currently
        //Attaching the non reversed part in the beginning to the start of reversed list which is currently marked by prev
        trailingTracker.next.next = reversalPointer;
        trailingTracker.next = prev;
        return dummy.next;
    }
}