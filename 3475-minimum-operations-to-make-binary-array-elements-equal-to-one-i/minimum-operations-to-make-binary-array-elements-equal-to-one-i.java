class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]==1){
                continue;
            }
            for(int j=i;j<=i+2;j++){
                nums[j]^=1;
            }
            ans++;
        }
        if(nums[n-1]==0||nums[n-2]==0){
            return -1;
        }
        return ans;
    }
}