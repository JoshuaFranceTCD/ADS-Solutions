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
    public int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

        //the diameter is the maximum length of the left subtree + right for a node    }

    private int dfs(TreeNode node){

        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        this.diameter = Math.max(this.diameter,left + right); // not + 1, the diameter is number of edges

        return 1 + Math.max(left,right);
        

        


    }
}
