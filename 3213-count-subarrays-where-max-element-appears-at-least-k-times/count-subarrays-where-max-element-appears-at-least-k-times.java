class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxele=-1;
        for(int i:nums){
            maxele=Math.max(maxele,i);
        }
        int i=0;
        int j=0;
        int n=nums.length;
        long res=0;
        long maxelecnt=0;
        while(j<n){
            if(nums[j]==maxele){
                maxelecnt++;
            }
            while(maxelecnt>=k){
                res+=(n-j);
                if(nums[i]==maxele){
                    maxelecnt--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}