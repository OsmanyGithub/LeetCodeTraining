class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Necesary for cases were k > n
        
        // Revers the entire array
        reverse(nums, 0, n - 1);
        
        // Reverse the actual first k element 
        reverse(nums, 0, k - 1);
        
        // Reverse the last elements
        reverse(nums, k, n - 1);
        
        
        
    }
    
    // Helper function for rotate the array
    private void reverse(int[] nums, int start, int end){
        // Swap elements 
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}