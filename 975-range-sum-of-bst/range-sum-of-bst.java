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
    int res=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root,low,high);
        return res;
    }
    public void inorder(TreeNode root,int l,int h){
        if(root==null){
            return;
        }
        inorder(root.left,l,h);
        if(root.val>=l&&root.val<=h){
            res+=root.val;
        }
        inorder(root.right,l,h);
    }
}