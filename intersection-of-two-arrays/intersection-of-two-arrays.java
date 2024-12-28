class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Compare arrays to get the largest and shortest array
        int [] shortestArray = (nums1.length < nums2.length) ? nums1 : nums2;
        int [] largestArray = (nums1.length < nums2.length) ? nums2 : nums1;
        
        // Create the Set seen to store values of the shortest array        
        Set<Integer> seen = new HashSet<>();
        for (int n: shortestArray){
            seen.add(n);
        }
        
        // Create the Set intersection to store the numbers that appears in both arrays         
        Set<Integer> intersection = new HashSet<>();
        for (int n: largestArray){
            if (seen.contains(n)){
                intersection.add(n);
            }
        }
        
        // Get the size of intersection       
        int size = intersection.size(); 
        // Create the Array result for store all the numbers of intersection
        int [] result = new int[size]; 
        
        // Add all numbers of Set intersection into the Array result
        int i = 0;
        for (int n: intersection){
            result[i] = n;
            i++;
        }
        
        return result;
    }
}