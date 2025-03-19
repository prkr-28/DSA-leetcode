class Solution {
    public int minOperations(int[] nums) {
        int i=0;
        int j=0;
        int opr=0;
        int n=nums.length;
        while(j<n){
            int temp=0;
            boolean p=false;
            if(nums[j]==0){
                temp=j;
                while(j+3<=n&&temp<j+3){
                    nums[temp]=(nums[temp]==1)?0:1;
                    temp++;
                    p=true;
                }
                if(p){
                    opr++;
                }
            }
            j++;
        }
        for(int num:nums){
            if(num==0){
                return -1;
            }
        }
        return opr;
    }
}