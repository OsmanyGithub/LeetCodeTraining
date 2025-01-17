class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store the sorted string as key and the original string as value
        Map<String, List<String>> map = new HashMap<>();
        
        // Traverse the array 
        for (String s: strs){
            // Create the key
            char[] stringArray = s.toCharArray();
            Arrays.sort(stringArray);
            String key = new String(stringArray);
            
            // Create a new list if not present in the map           
            if (!map.containsKey(key)){
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(key, newList);
            }
            
            // Update the map otherwise
            else{
                map.get(key).add(s);
            }
            
            
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> list: map.values()){
            result.add(list);
        }
        
        return result;
    }
}