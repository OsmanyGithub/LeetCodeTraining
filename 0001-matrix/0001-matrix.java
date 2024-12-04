class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean [][] visited = new boolean[m][n];
        int [][] distance = new int[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true; // Mark '0' cell as visited
                }
            }
        }
        
        // Perform BFS
        bfs(mat, distance, visited, queue, m, n);
        
        return distance;
        
    }
    
    private void bfs(int[][] mat, int[][] distance, boolean[][] visited, Queue<int[]> queue, int m,int n) {
        // Directions        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()){
            int [] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            for (int[] d: directions){
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]){
                    // Update distance
                    distance[nextRow][nextCol] = distance[row][col] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}