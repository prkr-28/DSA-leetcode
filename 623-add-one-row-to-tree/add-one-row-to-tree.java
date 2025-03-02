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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newnode=new TreeNode(val);
            newnode.left=root;
            return newnode;
        }
        int curr=1;
        return solve(root,val,depth,curr);
    }
    public TreeNode solve(TreeNode root,int val,int depth,int curr){
        if(root==null){
            return null;
        }
        if(curr==depth-1){
            TreeNode templeft=root.left;
            TreeNode tempright=root.right;

            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=templeft;
            root.right.right=tempright; 
        }
        root.left=solve(root.left,val,depth,curr+1);
        root.right=solve(root.right,val,depth,curr+1);
        return root;
    }
}