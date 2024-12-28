class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // Create a list to store the intersections        
        ArrayList<Integer> list = new ArrayList<>();
        
        // Use two pointers
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){ 
                // Add the number if not already included
                if (list.isEmpty() || list.get(list.size() -1) != nums1[i]){
                    list.add(nums1[i]);
                }
                i ++;
                j ++;
            }
            
            // Otherwise move the pointer of the smaller number
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        // Create the result array
        int size = list.size();
        int [] result = new int[size];
        
        // Copy the numbers from the list to the array
        for (int k = 0; k < size; k++){
            result[k] = list.get(k);
        }
        
        return result;
    }
}