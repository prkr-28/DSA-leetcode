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
    int maxlen=0;
    public void longestpath(TreeNode root,int length,boolean goleft){
        if(root==null){
            return;
        }
        maxlen=Math.max(maxlen,length);
        if(goleft==true){
            longestpath(root.left,length+1,false);
            longestpath(root.right,1,true);
        }
        else{
            longestpath(root.right,length+1,true);
            longestpath(root.left,1,false);
        }
    }
    public int longestZigZag(TreeNode root) {
        longestpath(root,0,true);
        longestpath(root,0,false);
        return maxlen;
    }
}