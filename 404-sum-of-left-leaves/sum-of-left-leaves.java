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
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root,null);
    }
    public int sum(TreeNode root,TreeNode parent){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            if(parent!=null&&parent.left==root){
                return root.val;
            }
        }
        int left=sum(root.left,root);
        int right=sum(root.right,root);
        return left+right;
    }
}