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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        // Map<Integer,Integer>map=new HashMap<>();
        int maxsum=Integer.MIN_VALUE;
        int smallestlevel=1;
        int level=1;
        while(!q.isEmpty()){
            int sz=q.size();
            int sum=0;
            for(int i=0;i<sz;i++){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(sum>maxsum){
                maxsum=sum;
                smallestlevel=level;
            }
            level++;
        }
        return smallestlevel;
    }
}