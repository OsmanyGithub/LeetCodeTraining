class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Edge case
        if (s.length() != t.length()){
            return false;
        }
        
        // Create two map to store Characters of both string at same index
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        
        // Iterate both string and store their characters
        for (int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Check consistency in both mapping
            if (mapST.containsKey(charS) && mapST.get(charS) != charT || 
               mapTS.containsKey(charT) && mapTS.get(charT) != charS){
                return false;
            }
            
            // Add mappings
            mapST.put(charS, charT);
            mapTS.put(charT, charS);          
        }
        
        return true;
    }
}