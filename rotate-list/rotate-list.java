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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) return head;
        
        int length = 1; // Start counting from head
        
        ListNode current = head; // Initialize pointer
        
        while(current.next != null){
            current = current.next;
            length ++;
        }
        
        ListNode tail = current; // Save the tail
        
        // Normalize k
        k = k % length;
        if (k == 0) return head; // Not need rotation
        
        // Due to the new head is at position (length - k), the previous node is the newTail
        int newTailPosition = length - k - 1;
        ListNode newTail = head; // Initialize pointer
        for (int i = 0; i < newTailPosition; i++){
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next; // Save the new Head
        
        newTail.next = null; // Break the list in the new tail
        tail.next = head; // Joint the original tail with the original head
        
        return newHead; // Return the new head
        
    }
}