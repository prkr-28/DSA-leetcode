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
    Map<TreeNode ,TreeNode>map=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        inorder(root);
        List<Integer>list=new ArrayList<>();
        bfs(root,k,target,list);
        return list;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left,root);
        }
        inorder(root.left);
        if(root.right!=null){
            map.put(root.right,root);
        }
        inorder(root.right);
    }
    public void bfs(TreeNode root,int k,TreeNode target,List<Integer>list){
        Queue<TreeNode>q=new LinkedList<>();
        Set<Integer>set=new HashSet<>();
        q.add(target);
        set.add(target.val);
        while(!q.isEmpty()){
            int sz=q.size();
            if(k==0){
                break;
            }
            while(sz-- > 0){
                TreeNode temp=q.poll();
                if(temp.left!=null&&!set.contains(temp.left.val)){
                    q.add(temp.left);
                    set.add(temp.left.val);
                }
                if(temp.right!=null&&!set.contains(temp.right.val)){
                    q.add(temp.right);
                    set.add(temp.right.val);
                }
                if(map.containsKey(temp)&&!set.contains(map.get(temp).val)){
                    q.add(map.get(temp));
                    set.add(map.get(temp).val);
                }
            }
            k--;
        }

        while(!q.isEmpty()){
            TreeNode nod=q.poll();
            list.add(nod.val);
        }
    }
}