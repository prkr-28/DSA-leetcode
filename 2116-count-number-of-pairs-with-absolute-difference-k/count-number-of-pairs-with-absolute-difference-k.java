class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] freqarr=new int[101];
        int res=0;
        for(int num:nums){
            freqarr[num]++;
        }
        for(int i=1;i<101-k;i++){
            res+=freqarr[i]*freqarr[i+k];
        }
        return res;
    }
}