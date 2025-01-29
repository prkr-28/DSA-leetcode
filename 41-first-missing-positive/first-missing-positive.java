class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean onepresent=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                onepresent=true;
            }
            if(nums[i]<=0||nums[i]>nums.length){
                nums[i]=1;
            }
        }
        if(onepresent==false){
            return 1;
        }
            for(int i=0;i<nums.length;i++){
                int temp=Math.abs(nums[i]);
                int idx=temp-1;
                if(nums[idx]<0){
                    continue;
                }else{
                    nums[idx]*=-1;
                }
            }

            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    return i+1;
                }
            }
            return nums.length+1;

    }
}