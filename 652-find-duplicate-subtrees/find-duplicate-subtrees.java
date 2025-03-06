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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String , Integer>map=new HashMap<>();
        ArrayList<TreeNode>arr=new ArrayList<>();
        get(root,map,arr);
        return arr;
    }
    public String get(TreeNode root,Map<String,Integer>map,ArrayList<TreeNode>res){
        if(root==null){
            return "N";
        }
        String s=String.valueOf(root.val)+","+get(root.left,map,res)+","+get(root.right,map,res);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            res.add(root);
        }
        return s;
    }
}