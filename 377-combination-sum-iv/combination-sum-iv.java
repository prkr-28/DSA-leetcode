class Solution {
    int n;
    int[][] t=new int[201][1001];
    public int combinationSum4(int[] nums, int target) {
        for(int i=0;i<201;i++){
            Arrays.fill(t[i],-1);
        }
        n=nums.length;
        return solve(0,nums,target);
    }
    public int solve(int idx,int[] nums,int target){
        if(target==0){
            return 1;
        }
        if(idx>=n||target<0){
            return 0;
        }
        if(t[idx][target]!=-1){
            return t[idx][target];
        }
        int take=solve(0,nums,target-nums[idx]);
        int nottake=solve(idx+1,nums,target);
        return t[idx][target]=take+nottake;
    }
}