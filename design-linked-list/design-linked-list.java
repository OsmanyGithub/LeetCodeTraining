class MyLinkedList {
    private class Node{
        int val;
        Node prev;
        Node next;
        
        public Node(int val){
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        this.size = 0;
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int index) {
        Node current = getNodeAt(index);
        
        return current == null ? -1 : current.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node nextNode = head.next;
        
        head.next = newNode;
        newNode.prev = head;
        
        if (nextNode != null) { // When the list is not empty
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        
        else{
            newNode.next = tail;
            tail.prev = newNode;
        }
        
        size ++;
        
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node prevNode = tail.prev;
        
        prevNode.next = newNode;
        newNode.prev = prevNode;
        
        newNode.next = tail;
        tail.prev = newNode;
        
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return; // Invalid index
        
        if (index == 0){
            addAtHead(val);
            return;
        }
        
        if (index == size){
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node prevNode = getNodeAt(index - 1);
        Node nextNode = prevNode.next;
        
        prevNode.next = newNode;
        newNode.prev = prevNode;
        
        newNode.next = nextNode;
        nextNode.prev = newNode;
        
        size ++;
        
    }
    
    public void deleteAtIndex(int index) {
        Node deleteNode = getNodeAt(index);
        if (deleteNode == null) return; // Invalid index
        
        Node prevNode = deleteNode.prev;
        Node nextNode = deleteNode.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        size--;
    }
    
    // Helper function getNodeAt
    private Node getNodeAt(int index){
        if (index < 0 || index >= size){
            return null; // Invalid index
        }
        Node current = head.next;

        for (int i = 0; i < index;i ++){
            current = current.next;
        }
        
        return current;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */