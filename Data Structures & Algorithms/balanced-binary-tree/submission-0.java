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
        dfs(root, 0);
        return balanced;

        
    }

    public int dfs(TreeNode node,int len){
        if(node == null) return len;
        int left = dfs(node.left, len+1);
        int right = dfs(node.right, len + 1);
        if( Math.abs(left - right) > 1) this.balanced = false;
        return Math.max(left,right);
    }
}
