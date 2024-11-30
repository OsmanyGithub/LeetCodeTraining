class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Map to memorize expresions and avoid duplicate computations
        Map<String, Integer> memo = new HashMap<>();
        
        // Perform DFS(Array nums, start Index, total sum upto this index, target, memo)
        return dfs(nums, 0, 0, target, memo);
    }
    
    private int dfs(int [] nums, int index, int sum, int target, Map<String,Integer> memo){
        // Create expresion key
        String key = index + "," + sum;
        
        // If the map has the key return the value
        if (memo.containsKey(key)) return memo.get(key);
        
        // if we arrive to the end of the array, if sum equals target that is a valid expression
        if (index == nums.length){
            return sum == target ? 1 : 0;
        }
        
        // start checking choices
        int add = dfs(nums, index + 1, sum +nums[index], target, memo); // check '+'
        int subtract = dfs(nums, index + 1, sum -nums[index], target, memo); // check '-'
        
        // Add the result of both checks: 1 for valid choise 0 othewise        
        int choices = add + subtract; 
        
        // push key and expression to memo        
        memo.put(key, choices);
        return choices;
    }
    
}