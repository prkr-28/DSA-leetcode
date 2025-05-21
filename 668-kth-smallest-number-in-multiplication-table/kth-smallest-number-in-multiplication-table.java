class Solution {
    public int findKthNumber(int m, int n, int k) {
        int si=1;
        int ei=m*n;
        while(si<ei){
            int mid=si+(ei-si)/2;
            if(countsmaller(m,n,mid)>=k){
                ei=mid;
            }
            else{
                si=mid+1;
            }
        }
        return ei;
    }
    public int countsmaller(int m,int n,int target){
        int count=0;
        for(int i=1;i<=m;i++){
            count+=Math.min(target/i,n);
        }
        return count;
    }
}