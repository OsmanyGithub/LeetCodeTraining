class MyCircularQueue {
    int head;
    int tail;
    int size;
    int[] array;

    public MyCircularQueue(int k) {
        head = -1;
        tail = -1;
        size = k;
        array = new int[k];
        
    }
    
    public boolean enQueue(int value) {        
        if (isFull() == true){
           return false; 
        }
        
        if (isEmpty() == true){
            head = 0;
        }
        
        tail = (tail + 1) % size;
        array[tail] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty() == true){
            return false;
        }
        
        if (tail == head){
            head = -1;
            tail = -1;
            return true;
        }
        
        head = (head + 1) % size;
        return true;
        
    }
    
    public int Front() {
        if (isEmpty() == true){
            return -1;
        }
        
        return array[head];
        
    }
    
    public int Rear() {
        if (isEmpty() == true){
            return -1;
        }
        
        return array[tail];
        
    }
    
    public boolean isEmpty() {
        return head == -1;
        
    }
    
    public boolean isFull() {
        return ((tail + 1) % size) == head;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */