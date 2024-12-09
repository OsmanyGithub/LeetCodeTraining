class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int visitedCount = dfs(rooms, 0, visited, 0); // Start DFS(from room 0)
        
        return visitedCount == rooms.size(); // Check if all rooms were visited
    }
    
    private int dfs(List<List<Integer>> rooms, int room, boolean[] visited, int count){
        if (visited[room]) return count; // If already visited, return count
        visited[room] = true; // Mark rooms as visited
        count++; // Increment count of visited rooms
        
        for(int key: rooms.get(room)){
            count = dfs(rooms, key, visited, count);
        }
        
        return count; // Return total visited rooms
    }
}