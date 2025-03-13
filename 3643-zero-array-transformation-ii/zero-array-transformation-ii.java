class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int s=queries.length;
        if(checkallzeroalready(nums)){
            return 0;
        }
        // for(int i=0;i<s;i++){
        //     if(check(nums,queries,i)){
        //         return i+1;
        //     }
        // }
        int si=0;
        int ei=s-1;
        int ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(check(nums,queries,mid)==true){
                ans=mid+1;
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return ans;
    }
    public boolean checkallzeroalready(int[] nums){
        for(int num:nums){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums,int[][] queries,int k){
        int[] diff=new int[nums.length+1];
        Arrays.fill(diff,0);
        for(int i=0;i<=k;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int x=queries[i][2];

            diff[l]+=x;
            diff[r+1]-=x;
        }
        int currsum=0;
        for(int j=0;j<nums.length;j++){
            currsum+=diff[j];
            diff[j]=currsum;
            if(nums[j]-diff[j]>0){
                return false;
            }
        }
        return true;
    }
}