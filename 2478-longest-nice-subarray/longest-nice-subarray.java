class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int res=1;
        int mask=0;
        while(j<n){
            while((mask&nums[j])!=0){
                mask=mask^nums[i];
                i++;
            }
            mask=(mask|nums[j]);
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}