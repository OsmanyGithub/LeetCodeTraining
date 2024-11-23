class Solution {
    public int numSquares(int n) {
        // Update move the for Loop after the while check,
        // this avoids unnecessary computations
        
        // Solution based on Lagrange's Four Square Theorem 
        //`Every positive integer can be represented as the sum of four squares,
        // or less.`
        // Time complexity O(√n) && Space complexity O(1)
        
        // if n <= 0, answer is 0
        if (n <= 0) return 0;
        
        // if n is a perfect square, answer is 1
        if (isPerfectSquare(n)) return 1;
        
        // if n = 4^a(8b + 7), the answer is 4
        while (n % 4 == 0) n /= 4;
        
        if (n % 8 == 7) return  4;
        
         // if n is the result of add two perfect square number, the answer is 2
        for(int i = 1; i*i <= n; i ++){
            if (isPerfectSquare(n - i*i)){
                return 2;
            }
        }

        // If non of the above are valid, the answer is 3
        return 3;
        
    }
    
    // Helper method for determine if a number is a perfect square
    private boolean isPerfectSquare(int x){
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}