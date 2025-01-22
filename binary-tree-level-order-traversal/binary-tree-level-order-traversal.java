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
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < size; i ++){
                TreeNode curr = queue.poll();
                TreeNode left = (curr.left != null) ? curr.left : null;
                TreeNode right = (curr.right != null) ? curr.right : null;
                
                list.add(curr.val);
                
                if (left != null) {
                    queue.offer(left);
                }
                
                if (right != null){
                    queue.offer(right);
                }
            }
            result.add(list);
        }
        
        return result;
        
    }
}