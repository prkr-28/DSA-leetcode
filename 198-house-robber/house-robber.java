class Solution {
    public int rob(int[] nums) {
        int prevrobbed=0;
        int maxrobbed=0;
        for(int i=0;i<nums.length;i++){
            int temp=Math.max(maxrobbed,prevrobbed+nums[i]);
            prevrobbed=maxrobbed;
            maxrobbed=temp;
        }
        return maxrobbed;
    }
}