class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int evencnt=1;
        int oddcnt=0;
        int prefsum=0;
        int ans=0;
        for(int num:arr){
            prefsum+=num;
            if(prefsum%2==0){
                ans=(ans+oddcnt)%mod;
                evencnt++;
            }
            else{
                ans=(ans+evencnt)%mod;
                oddcnt++;
            }
        }
        return ans;
    }
}