class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create a Set to store the values of the smaller array
        Set<Integer> seen = new HashSet<>();
        Set<Integer> match = new HashSet<>();
        
        // Put the values of the smaller array into the Set;
        if (nums1.length < nums2.length){
            for (int n: nums1){
                seen.add(n);
            }
            // Travers the longest array
            for (int n: nums2){
        // If seen has the same number, store in the first available index of result & increase index value
                if (seen.contains(n)){
                    if (!match.contains(n)) {
                        match.add(n);                       
                    } 
                }
            } 
        }
        else{
            for (int n : nums2){
                seen.add(n);
            }
            for (int n: nums1){
                if(seen.contains(n)){
                    if (!match.contains(n)){
                        match.add(n);
                    }
                }
            }
        }
        // Get the size of match Set
        int size = match.size();
        int []result = new int[size]; // Initialize result array using the previous size value
        int i = 0; // First available position in result
        for (int n: match){
            result[i++] = n;
        }
        return result;
    }
}