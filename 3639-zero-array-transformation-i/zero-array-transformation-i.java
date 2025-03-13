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
        for(int i=1;i<diffarray.length;i++){
            diffarray[i]=diffarray[i-1]+diffarray[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]+diffarray[i]>0){
                return false;
            }
        }
        return true;
    }
}