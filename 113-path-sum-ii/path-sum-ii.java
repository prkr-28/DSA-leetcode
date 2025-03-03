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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>arr=new ArrayList<>();
        int sum=0;
        solve(root,targetSum,sum,arr);
        return list;
    }
    public void solve(TreeNode root, int targetSum,int sum,List<Integer>arr){
        if(root==null){
            return;
        }
        sum+=root.val;
        arr.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==targetSum){
                list.add(new ArrayList<>(arr));
            }
        }else{
            solve(root.left,targetSum,sum,arr);
            solve(root.right,targetSum,sum,arr);
        }
        arr.remove(arr.size()-1);
    }
}