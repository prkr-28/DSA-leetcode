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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer>arr1=new ArrayList<>();
        ArrayList<Integer>arr2=new ArrayList<>();
        lefttrav(root.left,arr1);
        righttrav(root.right,arr2);
        if(arr1.equals(arr2)){
            return true;
        }
        return false;
    }
    public void lefttrav(TreeNode root,ArrayList<Integer>arr){
        if(root==null){
            arr.add(-1);
            return;
        }
        arr.add(root.val);
        lefttrav(root.left,arr);
        lefttrav(root.right,arr);
    }
    public void righttrav(TreeNode root,ArrayList<Integer>arr){
        if(root==null){
            arr.add(-1);
            return;
        }
        arr.add(root.val);
        righttrav(root.right,arr);
        righttrav(root.left,arr);
    }
}