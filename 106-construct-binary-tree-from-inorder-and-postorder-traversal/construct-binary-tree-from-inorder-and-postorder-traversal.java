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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos=postorder.length-1;
       return construct(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode construct(int[] inorder, int[] postorder,int si,int ei){
        if(si>ei){
            return null;
        }
        TreeNode root=new TreeNode(postorder[pos]);
        int div=0;
        for(int i=si;i<=ei;i++){
            if(postorder[pos]==inorder[i]){
                div=i;
                break;
            }
        }
        pos--;
        root.right=construct(inorder,postorder,div+1,ei);
        root.left=construct(inorder,postorder,si,div-1);
        return root;
    }
}