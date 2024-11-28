class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        // Use an Stack to store the indices of the array
        Stack<Integer> stack = new Stack<>();
        
        // Initialize an Array result of same length as temperature
        int [] result = new int[n];
        
        // Travers the Array from backwards and store indices in the stack
        for (int i = n - 1; i >= 0; i --){
            // Remove indices from the stack when the current temperature is >= than the temperature at the 
            // index store in the stack
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            
            // if the stack have an index, subtract the temperature at the stack index with the current index 
            // to know the difference between days
            if (!stack.isEmpty()){
                result[i] = stack.peek() - i;                
            }
            
            // If stack is empty, set the value of that index = 0; because not smaller temperature value have 
            // been found so far or the current indext is the last index of the array.
            else{
                result[i] = 0;
            }
            
            // Start pushing index into the stack            
            stack.push(i);
        }
        // Return array result        
        return result;
        
    }
}