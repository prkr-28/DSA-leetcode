class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int[] diffarray=new int[n+1];
        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            diffarray[l]-=1;
            diffarray[r+1]+=1;
        }
        int temp=0;
        for(int i=0;i<n;i++){
            temp+=diffarray[i];
            if(temp+nums[i]>0){
                return false;
            }
        }
        return true;
    }
}