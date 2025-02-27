/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode>arr1=new ArrayList<>();
        ArrayList<TreeNode>arr2=new ArrayList<>();
        getpath(root,p.val,arr1);
        getpath(root,q.val,arr2);
        int i=0;
        for(;i<arr1.size()&&i<arr2.size();i++){
            if(arr1.get(i)!=arr2.get(i)){
                break;
            }
        }
        return arr1.get(i-1);
    }

    public boolean getpath(TreeNode root,int n,ArrayList<TreeNode>arr){
        if(root==null){
            return false;
        }
        arr.add(root);
        if(root.val==n){
            return true;
        }
        boolean foundleft=getpath(root.left,n,arr);
        boolean foundright=getpath(root.right,n,arr);

        if(foundleft||foundright){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
}