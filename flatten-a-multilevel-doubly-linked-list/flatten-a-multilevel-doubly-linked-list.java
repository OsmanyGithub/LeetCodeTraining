/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head; // No flatten need it
        dfs(head); // Recursevely flatten the list
        return head;
    }
    // Helper function dfs
    private Node dfs(Node node){
        Node current = node; // Initialize the pointer
        Node last = null; // Keep track of the last processed node
        
        while (current != null){
            Node nextNode = current.next; // Store the next node
            
            if (current.child != null){ // If current has child
                Node childTail = dfs(current.child); // Flatten the list and store the tail
                
                // Update pointers
                current.next = current.child;
                current.child.prev = current;
                current.child = null; // Set child to null (Remove connection)
                
                if (nextNode != null){ // If current has next, Update pointers
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }
                last = childTail; // Update the last processed node
            }
            else{
                last = current; // Update the last processed node
            }
            current = nextNode; // Move the pointer
        }
        return last; // return the last processed node
    }
}