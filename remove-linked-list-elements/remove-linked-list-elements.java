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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node pointing to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize a pointer to traverse the list
        ListNode current = dummy;
        
        // Traverse the list and remove node with the target value
        while(current.next != null){
            if (current.next.val == val){
                // Bypass node with the target value
                current.next = current.next.next;
            }
            else {
                // Move to the next node
                current = current.next;
            }
        }
        // Return the new head (dummy.next)        
        return dummy.next;
        
    }
}