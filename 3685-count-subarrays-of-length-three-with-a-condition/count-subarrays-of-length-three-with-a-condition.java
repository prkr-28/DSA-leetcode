class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int count=0;
        int i=0;
        int j=1;
        int k=2;
        while(k<n){
            if(2*(nums[i]+nums[k])==nums[j]){
                count++;
            }
            i++;
            j++;
            k++;
        }
        return count;
    }
}