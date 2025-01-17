class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate the Array strs        
        for (String s: strs){
            char[] charArray = s.toCharArray(); // Convert to array of characters
            Arrays.sort(charArray); // Sort the array
            String key = new String(charArray); // Create the key
            
            // Create if the key is already in the map
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>()); // Create a new list
            }
            
            // Update the anagram list
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}