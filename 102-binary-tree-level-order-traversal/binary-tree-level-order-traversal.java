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
    List<List<Integer>>list=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return list;
    }
    public void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer>arr=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode temp=q.poll();
                arr.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            list.add(arr);
        }
    }
}