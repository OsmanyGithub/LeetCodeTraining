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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null; // No cycle in empty or single-node list
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null){
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
            
            if (slow == fast){ // Cycle found  
                ListNode entry = head; // Create entry pointer and the head
                
                // Cycle start where both pointers (entry & slow) meet                
                while(entry != slow){
                    entry = entry.next; // Move entry one step
                    slow = slow.next; // Move slow one step
                }
                return entry; // Or return slow, since they are the same at this point
            }
        }
        
        return null; // No cycle found
        
        /*
        Time Complexity: \U0001d442(\U0001d45b)
        Each pointer traverses the list at most twice.
        
        Space Complexity: \U0001d442(1)
        No additional data structures are used.
        */
        
    }
}