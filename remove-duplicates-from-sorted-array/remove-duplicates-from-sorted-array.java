class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1; // Slow pointer && unique numbers tracker, Start with 1 unique element on the first position
        
        // Loop using a fast pointer to check if the next element is a dupplicate
        for (int i = 1; i < nums.length; i ++){
            // if it finds a different element swap it with the k position
            if (nums[i] != nums[k - 1]){
                nums[k] = nums[i];  
                k ++; // Move k to the next position;
            }
        }
        
        return k;
        
    }
}