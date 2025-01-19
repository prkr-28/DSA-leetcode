class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int k=0;k<=31;k++){
            int countones=0;
            for(int i=0;i<nums.length;i++){
                if((nums[i]&(1<<k))!=0){
                    countones++;
                }
            }
            if(countones%3!=0){
                result=result|(1<<k);
            }
        }
        return result;
    }
}