class Solution {
    public int numSquares(int n) {
        // Step 1: Initialize the queue and visited set
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // Step 2: Add teh starting number `n` to the queue and visited set
        queue.add(n);
        visited.add(n);
        
        int level = 0; // BFS level (number of perfect squares)
        
        
        // Perform BFS
        while(!queue.isEmpty()){
            level ++;
            int size = queue.size();
            
            // Process all nodes in the current level            
            for(int i = 0; i < size; i ++){
                int curr = queue.poll();
                
                // Generate neighbors                
                for (int j = 1; j * j <= curr; j ++){
                    int next = curr - j * j;
                    
                    // If we reach 0, we found the least of perfect square sum for `n`
                    if (next == 0) return level;
                    
                    // Add invisited nodes to the queue and set                    
                    if (!visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        
        return level;
        
    }
}