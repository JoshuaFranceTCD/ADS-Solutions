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
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true; 
        dfs(root);
        return balanced;    
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;
        int left = 1 + dfs(node.left);
        int right = 1 + dfs(node.right);
        if( Math.abs(left - right) > 1) this.balanced = false;
        return Math.max(left,right);
    }
}
