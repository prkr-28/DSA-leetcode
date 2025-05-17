class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int sum=0;
        while(i<nums.length&&j<nums.length){
            sum+=Math.min(nums[i],nums[j]);
            i=i+2;
            j=j+2;
        }
        return sum;
    }
}