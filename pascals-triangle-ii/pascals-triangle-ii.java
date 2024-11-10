class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        row.add(1); // The first element is always 1
        
        // Loop from one to the rowIndex
        for (int i = 1; i <= rowIndex; i++){
            // Iterate backwards to update the row in-place and keep row integrity 
            for (int j = i - 1; j > 0; j --){
                row.set(j, row.get(j - 1) + row.get(j));
            }
            // End each row with 1
            row.add(1);
        }
        return row;
    }
}