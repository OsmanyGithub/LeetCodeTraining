class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Set left and right pointer
        int left = 0; 
        int right = numbers.length - 1;
        
        // Loop from both ends adding elements of both index until their sum be equal to target;
        
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            }
            else if (sum > target){ // If the sum is greater that target check the adjacent smaller value
                right --;
            }
            else{
                left ++;    // If the sum is smaller chech the adjacent bigger value            
            }
        } 
        
        return new int[0]; // Should never reach here because the problem guarantees a solution
    }
}