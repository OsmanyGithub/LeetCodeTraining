/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){ // Ensure fast and fast.next are not null
            slow = slow.next; // Move the slow pointer one step 
            fast = fast.next.next; // Move the fast pointer two steps
            
            if (fast == slow){
                return true;
            }
        }
        
        return false; 
    }
}