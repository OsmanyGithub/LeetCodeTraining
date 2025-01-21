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
    public List<Integer> postorderTraversal(TreeNode root) {
        // Two Stack approach
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root); // Push root into stack1
        
        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop(); // Processe the current node
            stack2.push(curr); // Push the node into stack2
            
            if (curr.left != null) stack1.push(curr.left);   // Push left child into stack1 if exist
            if (curr.right != null) stack1.push(curr.right); // Push right child into stack1 if exist
        }
        
        while(!stack2.isEmpty()){
            result.add(stack2.pop().val); // Pop all node and add its value to the list
        }
        
        return result;
        
    }
}