/*class Node {
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
        if (head == null) {
            return null;
        }

        // Step 1: Interweave the list with copied nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers to the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied lists
        current = head;
        Node dummy = new Node(0);
        Node copyCurrent = dummy;

        while (current != null) {
            copyCurrent.next = current.next;
            current.next = current.next.next;

            copyCurrent = copyCurrent.next;
            current = current.next;
        }

        return dummy.next;
    }
}
