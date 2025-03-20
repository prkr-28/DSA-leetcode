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

class Nodevalues{
    int maxsum;
    int maxnode;
    int minnode;
    // boolean isbst;
    public Nodevalues(int a,int b,int c){
        this.maxsum=a;
        this.maxnode=b;
        this.minnode=c;
        // this.isbst=d;
    }
}
class Solution {
    int maxsum=0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxsum;
    }
    public Nodevalues solve(TreeNode root){
        if(root==null){
            return new Nodevalues(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Nodevalues leftv=solve(root.left);
        Nodevalues rightv=solve(root.right);
        if(leftv.maxnode<root.val&&root.val<rightv.minnode){
            maxsum=Math.max(maxsum,leftv.maxsum+rightv.maxsum+root.val);
            return new Nodevalues(leftv.maxsum+rightv.maxsum+root.val,Math.max(root.val,rightv.maxnode),Math.min(root.val,leftv.minnode));
        }

        return new Nodevalues(Math.max(leftv.maxsum,rightv.maxsum),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}