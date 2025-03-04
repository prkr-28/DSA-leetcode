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
    int maxdiff;
    public int maxAncestorDiff(TreeNode root) {
        maxdiff=0;
        find(root);
        return maxdiff;
    }
    public void find(TreeNode root){
        if(root==null){
            return;
        }
        findmaxdiff(root,root.left);
        findmaxdiff(root,root.right);
        find(root.left);
        find(root.right);
    }
    public void findmaxdiff(TreeNode root,TreeNode child){
        if(child==null){
            return;
        }
        maxdiff=Math.max(maxdiff,Math.abs(root.val-child.val));
        findmaxdiff(root,child.left);
        findmaxdiff(root,child.right);
    }
}