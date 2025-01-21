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
        // One stack approach
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // On this variation we traverse the tree in a modified preorder (root → right → left)            
            if (node.left != null) stack.push(node.left);            
            if (node.right != null) stack.push(node.right);
          
        }
        
        // Reverse result list        
        int left = 0, right = result.size() -1;
        while(left < right){
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            left++;
            right --;
            
        }
        
        return result;
    }
}