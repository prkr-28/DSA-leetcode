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
    int res=Integer.MIN_VALUE;
    public int amountOfTime(TreeNode root, int start) {
        solve(root,start);
        return res;
    }
        
    public int solve(TreeNode root,int start){
        if(root==null){
            return 0;
        }
        int lh= solve(root.left,start);
        int rh=solve(root.right,start);
        if(root.val==start){
            res=Math.max(lh,rh);
            return -1;
        }
        else if(lh>=0&&rh>=0){
            return Math.max(lh,rh)+1;
        }
        else{
            int d=Math.abs(lh)+Math.abs(rh);
            res=Math.max(res,d);
            return Math.min(lh,rh)-1;
        }
    }
}