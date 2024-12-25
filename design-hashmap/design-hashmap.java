class MyHashMap {
    private class Node{
        int key, value;
        Node next; // Pointer to the next node in the list
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private class LinkedList{
        private Node head; // head of the liked list
        
        // Add a new node or update an existing node
        public void put(int key, int value){
            Node node = find(key);
            if (node != null){
                // Key already exists, update value
                node.value = value;
            }
            else{
                // Add new node at the head (simpler insertion)
                Node newNode = new Node(key, value);
                newNode.next = head;
                head = newNode;
            }
        }
        
        public Node find(int key){
            Node current = head;
            while (current != null){
                if (current.key == key){
                    return current; // Found the node
                }
                current = current.next; // Move to the next node
            }
            return null; // Key not found
        }
        // Remove a node by key
        public void remove (int key){
            Node current = head;
            Node prev = null;
            
            while (current != null){
                if (current.key == key){
                    if (prev == null){
                        head = current.next; // Removing the head node
                    }
                    else{
                        prev.next = current.next; // Bypass the current node
                    }
                    return;
                }
                
                prev = current;
                current = current.next;
            }
        }
        
        // Get the value for a key
        public int get (int key){
            Node node = find(key);
            return (node != null) ? node.value : -1; // Return value or -1 if not found
        }
    }
    
    private final int SIZE = 1000; // Number of buckets
    private LinkedList[] buckets; // Array of linked lists

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++){
            buckets[i] = new LinkedList(); // Initialize each bucket
        }
    }
    
    // Hash function
    private int hash(int key){
        return key % SIZE;
    }
    
    public void put(int key, int value) { // Insert or update key-value pair
        int index = hash(key);
        buckets[index].put(key, value);
    }
    
    public int get(int key) { // Retrieve the value for a key
        int index = hash(key);
        return buckets[index].get(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(key);
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */