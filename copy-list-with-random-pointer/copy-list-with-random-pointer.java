/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Interweave the list with copied nodes
        Node current = head;
        while(current != null){
            Node copy = new Node(current.val);
            
            // Insert copied node in the original list
            copy.next = current.next; 
            current.next = copy;
            
            current = copy.next; // Move to the next node
        }
        
        // Step 2: Assing the random pointers to the copied nodes
        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next; // Skip the copied node
        }
        
        // Step 3: Separate the original and copied lists
        current = head;
        Node dummy = new Node(0);
        Node dummyPointer = dummy;
        
        while(current != null){
            dummyPointer.next = current.next; // Connect copied pointer
            
            // Remove copied node from the original list
            current.next = current.next.next; 
            
            // Move both pointers
            dummyPointer = dummyPointer.next;
            current = current.next;
        }
        
        return dummy.next; // Return the head of the copied list
    }
}