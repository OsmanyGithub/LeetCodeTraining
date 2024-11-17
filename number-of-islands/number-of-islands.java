class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length; // Number of rows
        int m = grid[0].length; // Number of colums
        
        // Boolean array to track the visited land cells
        boolean [][] visited = new boolean[n][m]; 
        
        int islandCount = 0; // Island counter
        
        // Loop through the grid to find land cells
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                // If an unvisited land is found
                if (grid[i][j] == '1' && !visited[i][j]){
                    // Perform a bfs to mark all conected land cells
                    bfs(grid, visited, i, j, n, m);
                    
                    islandCount ++; // Increment the island counter
                }
            }
        }
        
        return islandCount;
    }
    
    // Helper Method Breath First Search
    public void bfs(char[][] grid, boolean [][] visited, int i, int j, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j}); // Add the land cell to the queue
        visited[i][j] = true; // Mark as visited
        
        // Array of directions (up, right, down, left)
        int [] directions = {-1 , 0, 1, 0, -1};
        
        while (!queue.isEmpty()){
            int [] currentCell = queue.poll();
            int row = currentCell[0];
            int col = currentCell[1];
            
            // Move in the 4 directions
            for(int index = 0; index < 4; index++){
                int nextRow = row + directions[index];
                int nextCol = col + directions[index + 1];
                
                // Check if the new cell is in bound and if it's an unvisited island
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m 
                   && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]){
                    // Add land to the queue
                    queue.add(new int[]{nextRow, nextCol});
                    // Mark the cell as visited
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        
        
    }
}