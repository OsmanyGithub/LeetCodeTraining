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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.addAll(inorderTraversal(root.left)); // Traverse the left subtree
            result.add(root.val); // Visite the Node without left child
            result.addAll(inorderTraversal(root.right)); // Traverse the right subtree
        }
        
        return result;
    }
}