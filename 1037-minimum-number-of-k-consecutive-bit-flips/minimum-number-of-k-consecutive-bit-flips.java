class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans=0;
        int flips=0;
        int n=nums.length;
        int[] flipped=new int[n];
        Arrays.fill(flipped,0);
        for(int i=0;i<n;i++){
            if(i>=k){
                flips-=flipped[i-k];
            }
            if((nums[i]==1&&flips%2==1)||nums[i]==0&&flips%2==0){
                if(i+k>n){
                    return -1;
                }
                ans++;
                flips++;
                flipped[i]=1;
            }
        }
        return ans;
    }
}