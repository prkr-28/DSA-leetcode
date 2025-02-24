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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(isIdenticle(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean isIdenticle(TreeNode root,TreeNode subroot){
        if(root==null&&subroot==null){
            return true;
        }
        else if(root==null||subroot==null||root.val!=subroot.val){
            return false;
        }
        if(!isIdenticle(root.left,subroot.left)){
            return false;
        }
        if(!isIdenticle(root.right,subroot.right)){
            return false;
        }
        return true;
    }
}