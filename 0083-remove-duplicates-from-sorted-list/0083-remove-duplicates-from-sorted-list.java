/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: Empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        // Iterate through the list
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found! Skip the next node
                current.next = current.next.next;
            } else {
                // No duplicate, move to the next unique node
                current = current.next;
            }
        }

        return head;
    }
}