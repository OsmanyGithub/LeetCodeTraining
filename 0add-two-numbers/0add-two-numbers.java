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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create dummy node and carry
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        // Traverse both lists        
        while(l1 != null || l2 != null || carry != 0){
            int v1 = (l1 != null) ? l1.val: 0; // Value from l1 or 0 if l1 is null
            int v2 = (l2 != null) ? l2.val: 0; // Value from l2 or 0 if l2 is null
            
            int sum = v1 + v2 + carry;
            carry = sum / 10; // Carry for the next iteration
            int digit = sum % 10; // Current digit to store
            
            current.next = new ListNode(digit);
            current = current.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
        
    }
}