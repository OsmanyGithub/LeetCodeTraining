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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2; // No reordering needed
        if (list2 == null) return list1; // No reordering needed
        
        // Create a dummy node
        ListNode dummy = new ListNode(0);
        
        // Initialize the pointer node
        ListNode current = dummy;
        
        // Travers both list untill one or both end
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            
            else{
                current.next = list2;
                list2 = list2.next;
            }
            
            current = current.next;
        }
        
        // Add the rest of the list if any
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        
        // Return the new head
        return dummy.next;
    }
}