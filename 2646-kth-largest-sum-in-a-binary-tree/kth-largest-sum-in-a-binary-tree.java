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
    PriorityQueue<Long>pq=new PriorityQueue<>(Collections.reverseOrder());
    public long kthLargestLevelSum(TreeNode root, int k) {
        bfs(root);
        if(pq.size()<k){
            return -1;
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
    public void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            long  sum=0;
            for(int i=0;i<sz;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            pq.add(sum);
        }
    }
}