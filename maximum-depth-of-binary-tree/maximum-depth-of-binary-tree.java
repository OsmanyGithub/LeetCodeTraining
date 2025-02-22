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
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }
    
    private int dfs(TreeNode node, int depth){
        if (node == null){
            return 0;
        }
        
        if(node.right == null && node.left == null){
            return depth;
        }
        
        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}