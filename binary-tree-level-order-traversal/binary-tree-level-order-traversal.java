/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, 0, result);
        return result;
    }
    
    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result){
        if (node == null) return;
        
        // Ensure result list hs enough levels
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        
        // Add current node's value to the corresponding level        
        result.get(level).add(node.val);
        
        // Recursively process left and right subtrees
        levelOrderHelper(node.left, level + 1, result);
        levelOrderHelper(node.right, level + 1, result);
    }
}