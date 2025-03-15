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
    int count=0;
    public int countPairs(TreeNode root,int distance) {
        solve(root,distance);
        return count;
    }
    public ArrayList<Integer>solve(TreeNode root,int dis){
        if(root==null){
            ArrayList<Integer>emptylist=new ArrayList<>();
            // emptylist.add(0);
            return emptylist;
        }
        if(root.left==null&&root.right==null){
            ArrayList<Integer>leaflist=new ArrayList<>();
            leaflist.add(1);
            return leaflist;
        }
        ArrayList<Integer>ldist=solve(root.left,dis);
        ArrayList<Integer>rdist=solve(root.right,dis);

        for(int l:ldist){
            for(int r:rdist){
                if(l+r<=dis){
                    count++;
                }
            }
        }
        ArrayList<Integer>currdistances=new ArrayList<>();
        for(int l:ldist){
            if(l+1<=dis){
                currdistances.add(l+1);
            }
        }

        for(int r:rdist){
            if(r+1<=dis){
                currdistances.add(r+1);
            }
        }
        return currdistances;
    }
}