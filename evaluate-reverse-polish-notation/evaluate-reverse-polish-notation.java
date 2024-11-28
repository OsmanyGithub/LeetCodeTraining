class Solution {
    public int evalRPN(String[] tokens) {
        // Use stack for store operands
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        
        // Iterate throw each token in the expresion
        for(String token: tokens){
            if (isOperator(token)){
                // Pop two operand from the stack
                int b = stack.pop();
                int a = stack.pop();
                
                // Calculate
                int curr = calculate(token, a, b);
                
                // Push the result back to the stack                
                stack.push(curr);
                
            }
            else{
                // Convert the numberic String into int and push it into the stack
                stack.push(Integer.parseInt(token)); 
            }
            
            
        }
        // At the end the stack contains the result of all the operations
        return stack.pop();
        
    // Space Complexity O(n). Where n is the number of tokens in the input array. We process each token once.
    // Time Complexity O(n). Due to in the worst case, the stack could hold all operands without any operators.
    }
    
    // Helper function calculate    
    private int calculate(String operator, int a, int b){
        switch(operator){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/":
                // Standard division
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default: throw new IllegalArgumentException("Illegal operator");
        }
    }
    // Helper function check if String a Mathematic operator
    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}