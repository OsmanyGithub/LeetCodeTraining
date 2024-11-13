class Solution {
    public String reverseWords(String s) {
        // Array to store word of the string
        String [] words = s.split(" ");
        
        // Travers the array reversing each word and add to answer
        for (int i = 0; i < words.length; i++){
            words[i] = new StringBuilder(words[i]).reverse().toString();  
        }
        
        // Combine the reversed words back into a single String concatenated with spaces   
        return String.join(" ", words).toString();
        
    }
}