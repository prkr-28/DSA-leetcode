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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        boolean evenlevel=true;
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            int prev=evenlevel?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<sz;i++){
                TreeNode temp=q.poll();
                if(evenlevel){
                    if(temp.val%2==0||temp.val<=prev){
                        return false;
                    }
                }
                else{
                    if(temp.val%2!=0||temp.val>=prev){
                        return false;
                    }
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                prev=temp.val;
            }
            evenlevel=!evenlevel;
        }
        return true;
    }
}