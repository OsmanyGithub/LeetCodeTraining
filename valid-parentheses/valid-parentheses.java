class Solution {
    public boolean isValid(String s) {
        // Use Stack for store the open brackets
        Stack<Character> stack = new Stack<>();
        
        // Travers the string converted in Array of characters
        for(char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            
            else {
                // If we have a closing bracket without a previos open bracket, is false
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // If brackets are '(){} or '([])' continue checking, otherwise 
                // String like this: '[{()]}', is false
                if (!isMatch(top, c)){
                    return false;
                }
            }
        }
        // If the stack is not empty, is false because we have an open bracket without its closing pair 
        return stack.isEmpty();
    }
    
    // Helper function, it makes the code cleaner and more maintainable, easy to include new cases in a future
    private boolean isMatch(char open, char close){
        return (open == '(' && close == ')') || (open == '{' && close == '}') || 
                (open == '[' && close == ']');
    }
}