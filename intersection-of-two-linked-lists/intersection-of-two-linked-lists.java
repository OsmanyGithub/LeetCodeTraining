/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either head is null, there can be no intersection
        if (headA == null || headB == null) return null;
        
        // Initialize two pointers        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        // Traverse both lists
        while (pointerA != pointerB){
            // Move each pointer to the next node, or to the head of the other list if it reaches the end
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        
        // Either they meet at the intersection point or at null       
        return pointerA;       
        
    }
}