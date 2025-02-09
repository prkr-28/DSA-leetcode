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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans=root.val;
        solve(root);
        return ans;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=Math.max(0,solve(root.left));
        int r=Math.max(0,solve(root.right));

        ans=Math.max(ans,l+r+root.val);
        return root.val+Math.max(l,r);
    }
}