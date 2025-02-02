class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int[] sorted=new int[n];
        for(int i=0;i<n;i++){
            int idx=0;
            for(int j=i;j<n;j++){
                sorted[idx]=nums[j];
                idx++;
            }
            for(int k=0;k<i;k++){
                sorted[idx]=nums[k];
                idx++;
            }
            boolean flag=true;
            for(int l=1;l<n;l++){
                if(sorted[l-1]>sorted[l]){
                    flag= false;
                    break;
                }
            }
            if(flag==true){
                return true;
            }
        }
        return false;
    }
}