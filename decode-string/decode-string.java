class Solution {
    public String decodeString(String s) {
        // Stack for store k
        Stack<Integer> countStack = new Stack<>();
        
        // Stack for store the decoded subString of each level
        Stack<StringBuilder> stringStack = new Stack<>();
        
        // Repetitions        
        int k = 0;
        
        // Current subString       
        StringBuilder currString = new StringBuilder();
        
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
            /* Build the reapeat count string. Digits are processed sequentially from left to right. 
            Multiplying by 10 shifts the number’s place value left, and adding the current digit completes
            the next step in forming the full number. */
                k = k * 10 + (c - '0'); 
            }
            
            else if (c == '['){
                // Push the current reapeat count and string into stacks
                countStack.push(k);
                stringStack.push(currString);
                k = 0; // Reset k for the next number
                currString = new StringBuilder(); // Reset currString as well
            }
            
            else if (c == ']'){
                // Decode the current string
                int repeat = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                while (repeat-- > 0){
                    decodedString.append(currString);
                }
                currString = decodedString;
            }
            
            else{
                currString.append(c);
            }
        }
        return currString.toString();
    }
}