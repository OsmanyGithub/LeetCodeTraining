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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node for edge case where head is removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move the first pointer n+1 steps to keep a gap of n between the pointers
        for (int i = 0; i <= n; i ++){
            first = first.next;
        }
        
        // Move both pointers until first reach the end
        while (first != null){
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from the end
        second.next = second.next.next;
        
        // Return the head or the new head which is dummy.next
        return dummy.next;
        
    }
}