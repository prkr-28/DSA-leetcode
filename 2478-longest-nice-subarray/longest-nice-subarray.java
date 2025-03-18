class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int result=0;
        for(int i=0;i<n;i++){
            int mask=0;
            f1 :for(int j=i;j<n;j++){
                if((mask&nums[j])!=0){
                    break f1;
                }
                mask=mask|nums[j];
                result=Math.max(result,j-i+1);
            }
        }
        return result;
    }
}