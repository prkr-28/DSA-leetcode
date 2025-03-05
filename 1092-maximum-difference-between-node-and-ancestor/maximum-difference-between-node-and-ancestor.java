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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return findmaxdiff(root, root.val, root.val);
    }
    public int findmaxdiff(TreeNode root,int max,int min){
        if(root==null){
            return Math.abs(max-min);
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        int l=findmaxdiff(root.left,max,min);
        int r=findmaxdiff(root.right,max,min);
        return Math.max(l,r);
    }
}