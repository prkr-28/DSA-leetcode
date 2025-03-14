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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level=0;
        int t_swaps=0;
        while(!q.isEmpty()){
            int sz=q.size();
            int[] arr=new int[sz];
            int i=0;
            while(sz-- >0){
                TreeNode tmp=q.poll();
                arr[i]=tmp.val;
                i++;
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
            t_swaps+=countswaps(arr);
        }
        return t_swaps;
    }
    public int countswaps(int[] arr){
        Map<Integer,Integer>map=new HashMap<>();
        int[] sortedarr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
            sortedarr[i]=arr[i];
        }
        int count=0;
        Arrays.sort(sortedarr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==sortedarr[i]){
                continue;
            }
            else{
                int curridx=map.get(sortedarr[i]);
                map.put(arr[i],curridx);
                int temp=arr[i];
                arr[i]=arr[curridx];
                arr[curridx]=temp;
                count++;
            }
        }
        return count;
    }
}