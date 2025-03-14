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
    public TreeNode lowestcommonancestor(TreeNode root,int p,int q){
        if(root==null||root.val==p||root.val==q){
            return root;
        }
        TreeNode findleft=lowestcommonancestor(root.left,p,q);
        TreeNode findright=lowestcommonancestor(root.right,p,q);
        if(findleft==null){
            return findright;
        }
        if(findright==null){
            return findleft;
        }
        return root;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lowestcommonancestor(root,startValue,destValue);
        StringBuilder sbleft=new StringBuilder();
        StringBuilder sbright=new StringBuilder();

        getpath(lca,startValue,sbleft);
        getpath(lca,destValue,sbright);

        for(int i=0;i<sbleft.length();i++){
            sbleft.setCharAt(i,'U');
        }
        sbleft.append(sbright);
        return sbleft.toString();
    }
    public boolean getpath(TreeNode lca,int target,StringBuilder sb){
        if(lca==null){
            return false;
        }
        if(lca.val==target){
            return true;
        }
        sb.append('L');
        if(getpath(lca.left,target,sb)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);

        sb.append('R');
        if(getpath(lca.right,target,sb)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
}