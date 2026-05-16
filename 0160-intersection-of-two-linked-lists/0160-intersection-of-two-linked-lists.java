/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Loop until the two pointers meet
        while (ptrA != ptrB) {
            // If ptrA reaches the end, switch to headB; else move to next
            ptrA = (ptrA == null) ? headB : ptrA.next;
            
            // If ptrB reaches the end, switch to headA; else move to next
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // Either they meet at the intersection node or both are null
        return ptrA;
    }
}