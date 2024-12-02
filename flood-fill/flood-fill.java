class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color){ // Avoid unnecessary processing
            dfs(image, sr, sc, oldColor, color);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor){
        // Base case: Out of bounds or not the target color
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor){
            return;
        }
        
        // Update the current pixel's color
        image[row][col] = newColor;
        
        // Explore all four directions
        dfs(image, row -1, col, oldColor, newColor); // Up
        dfs(image, row + 1, col, oldColor, newColor); // Down
        dfs(image, row, col - 1, oldColor, newColor); // Left
        dfs(image, row, col +1, oldColor, newColor); // Right
    }
}