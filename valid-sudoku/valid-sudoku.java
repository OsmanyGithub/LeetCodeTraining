class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> [] rows = new HashSet[9];
        Set<Character> [] cols = new HashSet[9];
        Set<Character> [] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int row = 0; row < 9; row ++){
            for (int col = 0; col < 9; col ++){
                char num = board[row][col];
                
                // Skip empty cells
                if(num == '.') continue;
                
                // Calculate the sub-box index
                int boxIndex = (row / 3) * 3 + (col / 3);
                
                // Check for duplicates in the current row, column and sub-box
                if(rows[row].contains(num) || cols[col].contains(num) || boxes[boxIndex].contains(num)){
                    return false;
                }
                
                // Add the number to the corresponding sets
                rows[row].add(num);
                cols[col].add(num);
                boxes[boxIndex].add(num);
                
            }
        }
        // If no duplicates were found, the board is valid
        return true;
    }
}