class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sz=nums.length;
        int target=nums[sz/2];
        int res=0;
        for(int i:nums){
            res+=Math.abs(target-i);
        }
        return res;
    }
}