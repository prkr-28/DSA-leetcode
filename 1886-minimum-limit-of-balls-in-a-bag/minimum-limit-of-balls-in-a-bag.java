class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int si=1;
        int ei=Integer.MIN_VALUE;;
        for(int i:nums){
            ei=Math.max(ei,i);
        }
        int ans=0;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(ispossible(nums,maxOperations,mid)){
                ans=mid;
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] nums,int maxop,int mid){
        int operations=0;
        for(int num:nums){
            int x=(int)Math.ceil((double)num/mid)-1;
            operations+=x;
            if(operations>maxop){
                return false;
            }
        }
        return true;
    }
}