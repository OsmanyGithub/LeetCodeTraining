class Solution {
    public boolean isHappy(int n) {
       // Use two pointers (slow and fast to detect cycles)
        int slow = n;
        int fast = getNext(n);
        
        // Continew until we find 1 or detect a cycle
        while (fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        // If fast reaches 1, the number is happy
        return fast == 1;
    }
    
    // Helper function to calculate the sum of the squares of digits    
    private int getNext(int number){
        int sum = 0;
        while(number > 0){
            int digit = number % 10;   // Extract the last digit
            sum += digit * digit;      // Add the square of digit to the sum
            number /= 10;              // Remove the last digit
        }
        
        return sum;
    }
}