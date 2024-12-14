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
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) return head;
        
        // Reverse the rest of the list       
        ListNode reversedList = reverseList(head.next);
        
        // Set the next node's next pointer to the current node      
        head.next.next = head; 
        
        // Terminate the reversed list, to brake original node's links
        head.next = null;
        
        return reversedList;      
    }
}