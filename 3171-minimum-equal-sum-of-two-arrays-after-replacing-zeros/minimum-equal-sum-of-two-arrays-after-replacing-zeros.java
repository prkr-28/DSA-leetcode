class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0;
        long zeroinnums1=0;

        long sum2=0;
        long zeroinnums2=0;
        for(int i:nums1){
            if(i==0){
                sum1+=1;
                zeroinnums1++;
            }
            sum1+=i;
        }
        for(int i:nums2){
            if(i==0){
                sum2+=1;
                zeroinnums2++;
            }
            sum2+=i;
        }

        if(sum1<sum2&&zeroinnums1==0){
            return -1;
        }
        if(sum1>sum2&&zeroinnums2==0){
            return -1;
        }
        return Math.max(sum1,sum2);
    }
}