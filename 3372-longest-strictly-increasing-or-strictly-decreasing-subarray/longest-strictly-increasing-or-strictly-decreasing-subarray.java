class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;
        int res=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                inc++;
                dec=1;
            }
            else if(nums[i-1]>nums[i]){
                dec++;
                inc=1;
            }
            else{
                inc=dec=1;
            }
            res=Math.max(res,Math.max(inc,dec));
        }
        return res;
    }
}