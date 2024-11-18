class Solution {
    public int openLock(String[] deadends, String target) {
        // Create deadSet for fast look up 
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        
        // Check edge - If initial state is a deadend;
        if (deadSet.contains("0000")) return -1;
        
        // Create a Queue for perform BFS
        Queue<String> queue = new LinkedList<>();
        
        // Create a visited Set to track the visited state combination
        Set<String> visited = new HashSet<>();
        
        // Add initial state to the queue and visted Set
        queue.offer("0000");
        visited.add("0000");
        
        int moves = 0; // Initialice the move counter
        
        // BFS
        while (!queue.isEmpty()){
            // This will give me the amount of state combination on each level
            int size = queue.size(); 
            
            // Loop through the previous combinations            
            for (int i = 0; i < size; i ++){
                String curr = queue.poll();
                
                // Check if we found the target
                if (curr.equals(target)) return  moves;
                
                // Generate all posible combinations 
                for (String next: getNextState(curr)){
                    // Add to the queue if not visited and not in the deadSet
                    if (!visited.contains(next) && !deadSet.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves ++; // Increment moves
        }
        // If target is not reached return -1
        return -1;
    }
    
    // Helper function
    private List<String> getNextState(String state){
        List<String> nextState = new ArrayList<>();
        
        char [] arr = state.toCharArray();
        
        // Loop through the 4 wheels generating new combinations
        for (int i = 0; i < 4; i ++){
            char original = arr[i];
            
            // Move the wheel forward
            arr[i] = original == '9' ? '0' : (char) (original + 1);
            nextState.add(new String(arr));
            
            // Move the wheel backward
            arr[i] = original == '0' ? '9' : (char) (original - 1);
            nextState.add(new String(arr));
            
            // Reset wheel to the initial position
            arr[i] = original;
        }
        return nextState;
    }
}