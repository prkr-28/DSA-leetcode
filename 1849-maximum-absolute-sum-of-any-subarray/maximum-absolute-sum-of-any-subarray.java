class Solution {
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(maxsum(nums),Math.abs(minsum(nums)));
    }
    public int maxsum(int[] nums){
        int sum=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
    public int minsum(int[] nums){
        int sum=nums[0];
        int minsum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.min(nums[i],nums[i]+sum);
            minsum=Math.min(minsum,sum);
        }
        return minsum;
    }
}