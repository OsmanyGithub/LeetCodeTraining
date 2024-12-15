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
    public ListNode oddEvenList(ListNode head) {
        // If the list has 0 or 1 node, no reordering is needed
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode odd = head;       // Pointer for the odd-indexed nodes
        ListNode even = head.next; // Pointer for the even-indexed nodes
        ListNode evenHead = even;  // Store the head of the even list for later connection
        
        // Traverse the list connecting nodes to theirs respective lists
        while (even != null && even.next != null){
            odd.next = even.next;   // Connect the next odd node
            odd = odd.next;         // Move the odd pointer forward
            
            even.next = odd.next;   // Connect the next even node
            even = even.next;       // Move the even pointer forward
        }
        
        odd.next = evenHead;        // Connect the odd list to the even list
        return head;                // Return the head of the reordered list
    }
}