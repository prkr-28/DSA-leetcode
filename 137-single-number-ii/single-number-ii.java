class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                i=i+2;
            }
            else{
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}