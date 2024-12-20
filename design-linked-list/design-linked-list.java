class MyLinkedList {
    private class Node{
        int val;
        Node prev, next;
        
        public Node(int val){
            this.val = val;
        }
    }
    
    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1; // Invalid index
        
        return getNodeAt(index).val;
        
        
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node nextNode = head.next;
        
        head.next = newNode;
        newNode.prev = head;
        
        newNode.next = nextNode;
        nextNode.prev = newNode;
        
        size++;      
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node prevNode = tail.prev;
        
        tail.prev = newNode;
        newNode.next = tail;
        
        newNode.prev = prevNode;
        prevNode.next = newNode;
        
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return; // Invalid index
        
        if (index <= 0){
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
        
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return; // Invalid index
        
        Node nodeToDelete = getNodeAt(index);
        
        Node prevNode = nodeToDelete.prev;
        Node nextNode = nodeToDelete.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        size --;
        
    }
    
    private Node getNodeAt(int index){
        Node current;
        if (index < size / 2){
            // Start from head
            current = head.next;
            for (int i = 0; i < index; i ++){
                current = current.next;
            }
        }
        
        else{
            current = tail.prev;
            for (int i = size - 1; i > index; i--){
                current = current.prev;
            }
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