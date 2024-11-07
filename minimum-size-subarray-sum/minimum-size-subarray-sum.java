class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;
        
        // Create a prefix array with an extra element
        int [] prefixSum = new int [n + 1];
        
        // Compute the prefix sums
        for (int i = 1; i <= n; i ++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        // For each prefix sum, look for the minimal subarray length using binary search
        for (int i = 0; i <= n; i ++){
            int targetSum = prefixSum[i] + target;
            
            // Use binary search to find the smallest index such that prefixSum[index] >= targetSum           
            int bound = Arrays.binarySearch(prefixSum, targetSum); 
            
            // If not found, binarySearch returns ( -insertionPoint - 1);
            if (bound < 0){
                bound = -bound - 1;
            }
            
            // Ensure bound is within the array bounds and update minLength if valid
            if (bound <= n){
                minLength = Math.min(minLength, bound - i);
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}