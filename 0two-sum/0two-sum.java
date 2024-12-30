class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate the array
        for (int i = 0; i < nums.length; i++){
            // Calculate the diff
            int diff = target - nums[i];
            
            // Check if the different exists in the map
            if (map.containsKey(diff)){
                // Return the difference and the current index
                return new int[]{map.get(diff), i}; 
            }
            
            // Store the current value and it index
            map.put(nums[i], i);
        }
        
        // We shouldn't arrive here because the solution in guaranty        
        return new int[]{};
        
        
    }
}