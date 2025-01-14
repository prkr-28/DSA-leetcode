class Solution {
    public int pivotIndex(int[] nums) {
        int currsum=0;
        int totalsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if((i-1)>=0){
                currsum+=nums[i-1];
            }else{
                currsum=0;
            }
            int rightsum=totalsum-currsum-nums[i];
            if(currsum==rightsum){
                return i;
            }
        }
        return -1;
    }
}