class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        if (n < 3) return 0;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        int max=0;
        int min=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(max,nums[i-1]);
            max=Math.max(max,nums[i-1]);
        }
        max=0;
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(max,nums[i+1]);
            max=Math.max(max,nums[i+1]);
        }
        
        long result = 0;
        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, (long)(leftmax[i] - nums[i]) * rightmax[i]);
        }

        return result;
    }
}