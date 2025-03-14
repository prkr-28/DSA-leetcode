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
    // public TreeNode lowestcommonancestor(TreeNode root,int p,int q){
    //     if(root==null||root.val==p||root.val==q){
    //         return root;
    //     }
    //     TreeNode findleft=lowestcommonancestor(root.left,p,q);
    //     TreeNode findright=lowestcommonancestor(root.right,p,q);
    //     if(findleft==null){
    //         return findright;
    //     }
    //     if(findright==null){
    //         return findleft;
    //     }
    //     return root;
    // }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        //TreeNode lca=lowestcommonancestor(root,startValue,destValue);
        StringBuilder sbleft=new StringBuilder();
        StringBuilder sbright=new StringBuilder();
        StringBuilder result=new StringBuilder();

        getpath(root,startValue,sbleft);
        getpath(root,destValue,sbright);

        int ptr=0;
        while(ptr<sbleft.length()&&ptr<sbright.length()&&sbleft.charAt(ptr)==sbright.charAt(ptr)){
            ptr++;
        }
        for(int i=ptr;i<sbleft.length();i++){
            result.append('U');
        }
        for(int i=ptr;i<sbright.length();i++){
            result.append(sbright.charAt(i));
        }
        return result.toString();
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