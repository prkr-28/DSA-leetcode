class Solution {
    public int maximumCount(int[] nums) {
        int pos=nums.length-lowerbound(nums,1);
        int neg=lowerbound(nums,0);
        return Math.max(pos,neg);
    }
    public int lowerbound(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}