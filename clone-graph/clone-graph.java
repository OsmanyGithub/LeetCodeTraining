/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       // Edge case: If the input graph is empty
        if (node == null) return null;
        
        // Map to keep track of the visited node and their clones
        Map<Node, Node> visited = new HashMap<>();
        
        // Start the DFS and return the cloned graph
        return dfs(node, visited);
    }
    
    // Helper function DFS
    private Node dfs(Node node, Map<Node, Node> visited){
        // If node has already been cloned, return the clone
        if (visited.containsKey(node)) return visited.get(node);
        
        // Clone the current clone
        Node clone = new Node(node.val);
        
        // Store Node in the map
        visited.put(node, clone);
        
        // Recursively clone all the neighbors
        for (Node neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor, visited));
        }
        
        return clone;
    }
}