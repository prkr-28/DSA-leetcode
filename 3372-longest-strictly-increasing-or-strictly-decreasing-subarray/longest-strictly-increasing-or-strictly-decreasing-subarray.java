class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;
        int maxinc=1;
        int maxdec=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                inc++;
                maxinc=Math.max(inc,maxinc);
            }
            else{
                inc=1;
            }

            if(nums[i-1]>nums[i]){
                dec++;
                maxdec=Math.max(dec,maxdec);
            }
            else{
                dec=1;
            }
        }
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i-1]>nums[i]){
        //         dec++;
        //         maxdec=Math.max(dec,maxdec);
        //     }
        //     else{
        //         dec=1;
        //     }
        // }
        return Math.max(maxinc,maxdec);
    }
}