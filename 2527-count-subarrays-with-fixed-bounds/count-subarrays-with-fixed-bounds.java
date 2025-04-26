class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minkidx=-1;
        int maxkidx=-1;
        int culpritidx=-1;
        long count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK||nums[i]>maxK){
                culpritidx=i;
            }
            if(nums[i]==minK){
                minkidx=i;
            }
            if(nums[i]==maxK){
                maxkidx=i;
            }
            long tmp=Math.min(maxkidx,minkidx)-culpritidx;
            count+=(tmp<0)?0:tmp;
        }
        return count;
    }
}