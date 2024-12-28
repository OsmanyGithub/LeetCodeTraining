class Solution {
    public boolean isHappy(int n) {
        // Use a Set to track numbers we've seen to detect cycles
        Set<Integer> seen = new HashSet<>();
        
        while(n != 1 && !seen.contains(n)){
            seen.add(n); // Mark the numbers as seen
            
            int sum = 0; 
            while(n > 0){
                int digit = n % 10;   // Extract the last digit
                sum += digit * digit; // Add the squares of the digit to the sum
                n /= 10;              // Remove the last digit 
            }
            
            n = sum; // Update n to the sum of squares
        }
        
        // Return true if we end at 1, false otherwise        
        return n == 1; 
    }
}