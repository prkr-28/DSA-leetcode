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

    public void makegraph(TreeNode root,TreeNode parent,Map<TreeNode,ArrayList<TreeNode>>map, Set<TreeNode>set){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            set.add(root);
        }
        if(parent==null){
            map.put(root,new ArrayList<>());
            if(root.left!=null){
                map.get(root).add(root.left);
            }
            if(root.right!=null){
                map.get(root).add(root.right);
            }
        }else{
            map.put(root,new ArrayList<>());
            map.get(root).add(parent);
            if(root.left!=null){
                map.get(root).add(root.left);
            }
            if(root.right!=null){
                map.get(root).add(root.right);
            }
        }
        makegraph(root.left,root,map,set);
        makegraph(root.right,root,map,set);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode,ArrayList<TreeNode>>map=new HashMap<>();
        Set<TreeNode>set=new HashSet<>();
        makegraph(root,null,map,set);

        int count=0;
        for(TreeNode n:set){
            Queue<TreeNode>q=new LinkedList<>();
            Set<TreeNode>visited=new HashSet<>();
            q.add(n);
            visited.add(n);
            for(int level=0;level<=distance;level++){
                int  sz=q.size();
                while(sz-- >0){
                    TreeNode tmp=q.poll();
                    if(tmp!=n&&set.contains(tmp)){
                        count++;
                    }
                    for(TreeNode tmps:map.get(tmp)){
                        if(!visited.contains(tmps)){
                            q.add(tmps);
                            visited.add(tmps);
                        }
                    }
                }
            }
        }
        return count/2;
    }
}