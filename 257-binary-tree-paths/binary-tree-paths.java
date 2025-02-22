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
    List<String>list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root,"");
        return list;
    }
    public void solve(TreeNode root ,String s){
        if(root.left==null&&root.right==null){
            list.add(s+root.val);
        }
        if(root.left!=null){
            solve(root.left,s+root.val+"->");
        }
        if(root.right!=null){
            solve(root.right,s+root.val+"->");
        }
    }
}