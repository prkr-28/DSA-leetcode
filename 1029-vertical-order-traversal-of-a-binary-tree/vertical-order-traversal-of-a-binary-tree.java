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

class info{
    TreeNode node;
    int hd;
    int level;
    public info(TreeNode d,int hd,int v){
        this.node=d;
        this.hd=hd;
        this.level=v;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>arr=new ArrayList<>();
        Queue<info>q=new LinkedList<>();
        TreeMap<Integer,PriorityQueue<int[]>>map=new TreeMap<>();
        int min=0;
        int max=0;
        q.add(new info(root,0,0));
        while(!q.isEmpty()){
            info temp=q.poll();
            int level=temp.level;
            int hd=temp.hd;
            TreeNode node=temp.node;
            map.putIfAbsent(hd,new PriorityQueue<>((a,b)-> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])));
            map.get(hd).add(new int[]{level,node.val});
            if(node.left!=null){
                q.add(new info(node.left,hd-1,level+1));
            }
            if(node.right!=null){
                q.add(new info(node.right,hd+1,level+1));
            }
        }
        for(PriorityQueue<int[]> pq:map.values()){
            List<Integer>l=new ArrayList<>();
            while(!pq.isEmpty()){
                l.add(pq.poll()[1]);
            }
            arr.add(l);
        }
        return arr;
    }
}