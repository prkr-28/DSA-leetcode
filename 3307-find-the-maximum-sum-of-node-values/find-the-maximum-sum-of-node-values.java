class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        long count=0;
        long minnuksaan=Long.MAX_VALUE;
        for(int i:nums){
            if((i^k)>i){
                sum+=(i^k);
                count++;
            }else{
                sum+=i;
            }
            minnuksaan=Math.min(minnuksaan,Math.abs((i^k)-i));
        }
        if(count%2==0){
            return sum;
        }
        return sum-minnuksaan;
    }
}