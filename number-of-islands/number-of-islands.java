class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        boolean [][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j, m, n);
                }
                
            }
        }
        return count;
    }
    // Helper function dfs
    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n){
        // Directions
        int [] directions = {-1, 0, 1, 0, -1};
        
        // Mark cell as visited
        visited[i][j] = true;

        for(int indx = 0; indx < 4; indx ++){
            int nextRow = i + directions[indx];
            int nextCol = j + directions[indx + 1];

            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n 
                && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]){
                dfs(grid, visited, nextRow, nextCol, m, n);
            }
        }
    }
}