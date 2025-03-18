class Solution {
    public int maxProduct(int[] nums) {
        int l=0;
        int sl=0;
        for(int i:nums){
            if(i>l){
                sl=l;
                l=i;
            }
            else{
                sl=Math.max(sl,i);
            }
        }
        return (l-1)*(sl-1);
    }
}