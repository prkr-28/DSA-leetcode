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
    public void makegraph(Map<Integer,ArrayList<Integer>>map,int parent,TreeNode curr){
        if(curr==null){
            return;
        }
        if(parent==-1){
            map.put(curr.val,new ArrayList<>());
            if(curr.left!=null){
                map.get(curr.val).add(curr.left.val);
            }
            if(curr.right!=null){
                map.get(curr.val).add(curr.right.val);
            }
        }
        else{
            map.put(curr.val,new ArrayList<>());
            map.get(curr.val).add(parent);
            if(curr.left!=null){
                map.get(curr.val).add(curr.left.val);
            }
            if(curr.right!=null){
                map.get(curr.val).add(curr.right.val);
            }
        }
        makegraph(map,curr.val,curr.left);
        makegraph(map,curr.val,curr.right);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();
        makegraph(map,-1,root);
        Queue<Integer>q=new LinkedList<>();
        Set<Integer>visited=new HashSet<>();
        q.add(start);
        visited.add(start);
        int minutes=0;
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-- >0){
                int curr=q.poll();
                for(int n:map.get(curr)){
                    if(!visited.contains(n)){
                        q.add(n);
                        visited.add(n);
                    }
                }
            }
            minutes++;
        }
        return minutes-1;
    }
}