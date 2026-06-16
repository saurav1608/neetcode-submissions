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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = new ListNode();
        dummy.next = curr;
        while (list1 != null && list2!=null) {
            ListNode nodeToBeAdded = new ListNode();
            if (list1.val <= list2.val) {
                nodeToBeAdded.val = list1.val;
                list1 = list1.next;
            } else {
                nodeToBeAdded.val = list2.val;
                list2 = list2.next; 
            }
            curr.next = nodeToBeAdded;
            curr = curr.next;
        }
        while (list1 != null) {
            ListNode nodeToBeAdded = new ListNode();
            nodeToBeAdded.val = list1.val;
            list1 = list1.next;
            curr.next = nodeToBeAdded;
            curr = curr.next;
        }
        while (list2 != null) {
            ListNode nodeToBeAdded = new ListNode();
            nodeToBeAdded.val = list2.val;
            list2 = list2.next;
            curr.next = nodeToBeAdded;
            curr = curr.next;
        }
        return dummy.next.next;
        
    }
}