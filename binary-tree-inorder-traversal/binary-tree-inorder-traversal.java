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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current); 
                current = current.left; // Traverse the left subtree
            }
            
            // current is null, start to pop the stack
            current = stack.pop();
            result.add(current.val); // Visite the node
            
            current = current.right; // Traverse the right subtree
        }
        
        return result;
    }
}