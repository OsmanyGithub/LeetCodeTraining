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
       // Edge case null node
        if (node == null) return null;
        
        // Use a HashMap for keep track of the visited node
        Map<Node, Node> visited = new HashMap<>();
        
        // Recursively visited nodes and neighbors and return node
        return dfs(node, visited);
    }
    
    // Helper function DFS
    private Node dfs(Node node, Map<Node, Node> visited){
        // If node has been already visited return
        if (visited.containsKey(node)) return visited.get(node);
        
        // Create instance of the node clone
        Node clone = new Node(node.val);
        
        // Store Node in the map
        visited.put(node, clone);
        
        // Recursively visit nodes and neighbors
        for (Node neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor, visited));
        }
        
        return clone;
    }
}