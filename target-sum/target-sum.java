class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Map to store results(index, current_sum)
        Map<String, Integer> memo = new HashMap<>();
        
        // Start DFS with index 0 and sum = 0
        return dfs(nums, 0, 0, target, memo);
    }
    
    private int dfs(int []nums, int index, int sum, int target, Map<String, Integer> memo){
        // Create a unique key for the current state
        String key = index + "," + sum;
        
        // If already computed, return the result
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        
        // Base case: if we reach teh end of the array
        if (index == nums.length){
            return sum == target ? 1 : 0;
        }
        
        // Recursive case: explore both +nums[index] and -nums[index]
        int add = dfs(nums, index + 1, sum + nums[index], target, memo);
        int subtract = dfs(nums, index + 1, sum -nums[index], target, memo);
        
        // Total ways for the current state
        int totalWays = add + subtract;
        
        // Store the result in the memo map
        memo.put(key, totalWays);
        
        return totalWays;
    }
}