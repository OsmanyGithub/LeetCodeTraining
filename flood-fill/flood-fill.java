class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        int newColor = color;
        
        bfs(image, queue, oldColor, newColor);
        
        return image;
    }
    
    private void bfs(int [][] image, Queue<int[]> queue, int oldColor, int newColor){
        int [] directions = {-1, 0, 1, 0, -1};
        int m = image.length;
        int n = image[0].length;
        boolean [][] visited = new boolean[m][n];
        
        
        while (!queue.isEmpty()){
            int [] pixel = queue.poll();
            
            int row = pixel[0];
            int col = pixel[1];
            visited[row][col] = true;
            image[row][col] = newColor;
            
            for (int i = 0; i < 4; i++){
                int nextRow = row + directions[i];
                int nextCol = col + directions[i + 1];
                
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && image[nextRow][nextCol] == oldColor && !visited[nextRow][nextCol]){
                    image[nextRow][nextCol] = newColor;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            
        }
    }
}