class Solution {
    public String reverseWords(String s) {
        // Array to store all words in s without leading or trailing spaces
        String[] words = s.trim().split("\\s+");
        
        // StringBuilder for better performance 
        StringBuilder result = new StringBuilder();
        
        // Travers Array words from backwards and update result
        for (int i = words.length - 1; i >= 0; i --){
            result.append(words[i]);
            // If we are in the first position do not add space
            if (i != 0){
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}