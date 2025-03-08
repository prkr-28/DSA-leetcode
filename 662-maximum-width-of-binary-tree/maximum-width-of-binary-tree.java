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
 class Pair{
    TreeNode node;
    int idx;
    public Pair(TreeNode n,int i){
        this.node=n;
        this.idx=i;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth=-1;
        ArrayDeque<Pair>q=new ArrayDeque<>();
        int idx=0;
        q.add(new Pair(root,idx));
        while(!q.isEmpty()){
            int sz=q.size();
            Pair p=q.peekFirst();
            Pair r=q.peekLast();
            maxwidth=Math.max(maxwidth,r.idx-p.idx+1);
            for(int i=0;i<sz;i++){
                Pair temp=q.poll();
                if(temp.node.left!=null){
                    q.add(new Pair(temp.node.left,2*temp.idx+1));
                }
                if(temp.node.right!=null){
                    q.add(new Pair(temp.node.right,2*temp.idx+2));
                }
            }
        }
        return maxwidth;
    }
}