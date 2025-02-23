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
    int index;
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        index=0;
        n=traversal.length();
        return solve(traversal,0);
    }
    public TreeNode solve(String s,int depth){
        if(index>=n){
            return null;
        }
        int d_count=0;
        int tempidx=index;
        while(tempidx<n&&!Character.isDigit(s.charAt(tempidx))){
            d_count++;
            tempidx++;
        }
        if(d_count!=depth){
            return null;
        }
        index=tempidx;
        int val=0;
        while(index<n&&Character.isDigit(s.charAt(index))){
            val=val*10+(s.charAt(index)-'0');
            index++;
        }
        TreeNode root=new TreeNode(val);
        root.left=solve(s,depth+1);
        root.right=solve(s,depth+1);
        return root;
    }
}