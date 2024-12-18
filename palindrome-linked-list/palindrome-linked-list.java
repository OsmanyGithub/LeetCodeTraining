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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true; // A single node or empty list is always a palindrome
        }
        
        // Find the middle of the list
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list
        
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        
        ListNode reversedCopy = secondHalf; // To restore the list later(optional)
       
        while (secondHalf != null){
            if (firstHalf.val != secondHalf.val){
                return false; // Values not match
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: Restore the list        
        ListNode originalSecondHalf = reverseList(reversedCopy);
        
        return true; // The list is palindrome
        
    }
    
    // Helper function to reverse a linked List   
    private ListNode reverseList(ListNode node){
        ListNode curr = node, prev = null;
        
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;
    }
}