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
    public int goodNodes(TreeNode root) {
        int max = -101;
    
        return  dfs(root,max);
        
    }
    public int dfs(TreeNode node, int max){

        if(node == null) return 0;
        int good = 0;
        if(node.val >= max ) good = 1;
        int newMax  = Math.max(max,node.val);
        return good + dfs(node.left,newMax) + dfs(node.right,newMax);





    }
}
