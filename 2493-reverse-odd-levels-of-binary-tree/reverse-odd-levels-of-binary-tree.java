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
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left,root.right,1);
        return root;
    }
    public void solve(TreeNode left,TreeNode right,int level){
        if(left==null&&right==null){
            return;
        }
        if(level%2==1){
            int tmp=left.val;
            left.val=right.val;
            right.val=tmp;
        }
        solve(left.left,right.right,level+1);
        solve(left.right,right.left,level+1);
    }
}