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
    List<List<Integer>>arr=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        solve(root);
        return arr;
    }
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty()){
            List<Integer>ar=new ArrayList<>();
            if(!s1.isEmpty()){
                while (!s1.isEmpty()) {
                    TreeNode temp = s1.pop();
                    ar.add(temp.val);
                    if (temp.left != null) s2.push(temp.left);
                    if (temp.right != null) s2.push(temp.right);
                }
            }
            else{
                while (!s2.isEmpty()) {
                    TreeNode temp = s2.pop();
                    ar.add(temp.val);
                    if (temp.right != null) s1.push(temp.right);
                    if (temp.left != null) s1.push(temp.left);
                }
            }
            arr.add(ar);
        }
    }
}