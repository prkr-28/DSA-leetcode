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
    ArrayList<Integer>arr=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balance(0,arr.size()-1);
    }
    public TreeNode balance(int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=si+(ei-si)/2;
        TreeNode newnode=new TreeNode(arr.get(mid));
        newnode.left=balance(si,mid-1);
        newnode.right=balance(mid+1,ei);
        return newnode;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}