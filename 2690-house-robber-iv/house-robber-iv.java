class Solution {
    public int minCapability(int[] nums, int k) {
        int ans=0;
        int si=1;
        int ei=0;
        for(int i=0;i<nums.length;i++){
            ei=Math.max(ei,nums[i]);
        }
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(canrob(nums,mid,k)){
                ans=mid;
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return ans;
    }
    public boolean canrob(int[] nums,int mid,int k){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                count++;
                i++;
            }
        }
        return count>=k;
    }
}