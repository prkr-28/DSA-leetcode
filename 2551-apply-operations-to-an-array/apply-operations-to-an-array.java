class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
            else{
                continue;
            }
        }
        int a=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[a]=nums[i];
                a++;
            }
        }
        for(int i=a;i<n;i++){
            nums[i]=0;
        }
        return nums;
    }
}