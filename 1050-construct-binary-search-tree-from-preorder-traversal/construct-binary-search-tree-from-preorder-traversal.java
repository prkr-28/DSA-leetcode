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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode solve(int[] p,int upprbound,int[] i){
        if(i[0]>=p.length||p[i[0]]>upprbound){
            return null;
        }
        TreeNode newnode=new TreeNode(p[i[0]++]);
        newnode.left=solve(p,newnode.val,i);
        newnode.right=solve(p,upprbound,i);
        return newnode;
    }

}