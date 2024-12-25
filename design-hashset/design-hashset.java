class MyHashSet {
    boolean [] visited;
    Integer size;

    public MyHashSet() {
        size = 1000001;
        visited = new boolean[size];
        
    }
    
    public void add(int key) {
        if (!visited[key]){
            visited[key] = true;
        }
        
    }
    
    public void remove(int key) {
        if (visited[key]){
            visited[key] = false;
        }
        
    }
    
    public boolean contains(int key) {
        if (visited[key]){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */