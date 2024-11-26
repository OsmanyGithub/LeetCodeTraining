class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == ')' || c == '}' || c == ']'){
                if (stack.isEmpty()) {
                    return false;
                }
                
                char match = stack.pop();
                if(c == ')' && match != '(' || c == '}' && match != '{' || c == ']' && match != '['){
                    return false; 
                }
                
            }
            else if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
        
    }
}