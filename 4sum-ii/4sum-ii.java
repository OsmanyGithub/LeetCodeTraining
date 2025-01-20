class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Create a Map to store the sum of the first two arrays an its frequency
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // Initialize a counter for the tuple solutions
        int n = nums1.length;
        
        // Compute the sum of all posible combination amoung the first two arrays
        for (int n1 : nums1){
            for (int n2: nums2){
                int sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1); // Store the partial sum in the map
            }
        }
            
        // Compute the sum of all posible combination amoung the last two arrays
        for (int n3: nums3){
            for (int n4: nums4){
                int sum = n3 + n4;
                // If the negation of the sum exists in the map add its occurrence to count, otherwise 
                // add the default value (0) in this case  
                count += map.getOrDefault(-sum, 0); 
            }
        }
        
        return count;
    }
}