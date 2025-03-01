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
    int pos;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pos=0;
        return construct(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode construct(int[] preorder, int[] inorder,int si,int ei){
        if(si>inorder.length||si>ei){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pos]);
        int div=0;
        for(int i=si;i<=ei;i++){
            if(preorder[pos]==inorder[i]){
                div=i;
                break;
            }
        }
        pos++;
        root.left=construct(preorder,inorder,si,div-1);
        root.right=construct(preorder,inorder,div+1,ei);
        return root;
    }
}