class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        long count=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int target=lower-nums[i];
            int idx=lower_bound(nums,i+1,n-1,target);
            int x=idx-i-1;
            target=upper-nums[i];
            idx=upper_bound(nums,i+1,n-1,target);
            int y=idx-i-1;

            count+=(y-x);
        }
        return count;
    }
    public int lower_bound(int[] nums,int si,int ei,int target){
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]<target){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return si;
    }
    public int upper_bound(int[]nums,int si,int ei,int target){
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]<=target){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return si;
    }
}