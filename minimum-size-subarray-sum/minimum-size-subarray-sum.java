class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0; // left pointer
        int sum = 0;
        
        // Loop trough the array to perform the sum 
        for (int right = 0; right < nums.length; right ++){
            sum += nums[right];
            
            while (sum >= target){
                minLength = Math.min(minLength, right - left + 1); // update minLength
                // Shrink the window
                sum -= nums[left]; 
                left ++;
            } 
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}