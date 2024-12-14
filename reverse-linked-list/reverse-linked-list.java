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
    public ListNode reverseList(ListNode head) {
        // Initialize three pointers
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        // Iterate through the list
        while(current != null){
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current;      // Move prev to the current node
            current = next;      // Move current pointer
        }
        // At the end, prev is the new head        
        return prev; 
    }
}