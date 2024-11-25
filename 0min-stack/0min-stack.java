class MinStack {
    private List<int[]> stack;
    
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        // If stack is Empty, current minimum is the value itself
        if (stack.isEmpty()){
           stack.add(new int []{val, val}); 
        }
        // Otherwise, compare the current value with the previous minimum
        else{
            int currentMin = Math.min(val, stack.get(stack.size() - 1)[1]);
            stack.add(new int[]{val, currentMin});
            
        }
        
        
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.remove(stack.size() - 1);
        }
        
    }
    
    public int top() {
        return stack.get(stack.size() - 1)[0];
    }
    
    public int getMin() {
        return stack.get(stack.size() - 1)[1];
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */