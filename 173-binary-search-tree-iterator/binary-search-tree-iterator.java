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
// o(1) space and o(h) complexity soln...
class BSTIterator {

    Stack<TreeNode>st=new Stack<>();
    public BSTIterator(TreeNode root) {
        construct(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        construct(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return st.isEmpty()?false:true;
    }
    public void construct(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */