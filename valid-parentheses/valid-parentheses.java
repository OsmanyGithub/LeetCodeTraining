class Solution {
    public boolean isValid(String s) {
        // Use stack for store the open brackets
        Stack<Character> stack = new Stack<>();
        
        // Travers the String s converted in a Char Array to easly compare characters;
        for (char c: s.toCharArray()){
            if (c == ')' || c == '}' || c == ']'){
                // If stack is empty when we find a close bracket the String is invalid
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Otherwise remove from the stack to check the match                
                char match = stack.pop();
                if(c == ')' && match != '(' || c == '}' && match != '{' || c == ']' && match != '['){
                    return false; 
                }
                
            }
            // Store in the stack all the open brackets
            else if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
        }
        
        // If at the end of the loop the stack has any character the String is invalid        
        return stack.isEmpty();
        
    }
}