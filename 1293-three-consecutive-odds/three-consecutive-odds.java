class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddcount=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                oddcount=0;
            }
            else{
                oddcount++;
            }
            if(oddcount==3){
                return true;
            }
        }
        return false;
    }
}