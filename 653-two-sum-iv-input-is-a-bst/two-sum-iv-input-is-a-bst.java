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
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int l=0;
        int r=arr.size()-1;
        while(l<r){
            int sum=arr.get(l)+arr.get(r);
            if(sum==k){
                return true;
            }
            else if(sum>k){
                r--;
            }
            else{
                l++;
            }
        }
        return false;
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