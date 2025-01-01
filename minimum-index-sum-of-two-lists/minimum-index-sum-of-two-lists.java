class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Map one of the list (String, index)
        Map<String, Integer> mapList1 = new HashMap<>();
        for (int i = 0; i < list1.length; i ++){
            mapList1.put(list1[i], i);
        }
        
        int minSum = Integer.MAX_VALUE; // Track the min index Sum
        
        // Create List to store common words
        List<String> result = new ArrayList<>();
        
        // Finding common strings and updating results based on index sums.
        for (int i = 0; i < list2.length; i++){
            String word = list2[i];
            if (mapList1.containsKey(word)){
                int sum = i + mapList1.get(word);
                if (sum < minSum){    // Found a new min
                    result.clear();
                    result.add(word);
                    minSum = sum; // Update minSum
                }
                
                else if (sum == minSum){  // Equal sum of indices
                    result.add(word);
                }
            }
        }
        
        // Return result as Array
        return result.toArray(new String[0]);
    }
}