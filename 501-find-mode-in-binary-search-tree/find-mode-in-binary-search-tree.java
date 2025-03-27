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
    Map<Integer,Integer>map=new HashMap<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer>list=new ArrayList<>();
        int maxfreq=-1;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();

            if(maxfreq<val){
                maxfreq=val;
                list.clear();
                list.add(key);
            }
            else if(maxfreq==val){
                list.add(key);
            }
        }

        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inorder(root.right);
    }
}