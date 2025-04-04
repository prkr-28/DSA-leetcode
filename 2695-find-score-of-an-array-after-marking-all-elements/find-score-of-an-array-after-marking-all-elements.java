class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        long score=0;
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        for(int i=0;i<n;i++){
            long val=arr[i][0];
            int idx=arr[i][1];
            if(nums[idx]!=0){
                score+=val;

                if(idx-1>=0){
                    nums[idx-1]=0;
                }
                if(idx+1<n){
                    nums[idx+1]=0;
                }
            }
        }
        return score;
    }
}

// [1,1][2,0][2,5][3,2][4,3][5,4]