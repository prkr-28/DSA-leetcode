class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int maxcandies=0;
        long totalcandies=0;
        int res=0;
        for(int i=0;i<n;i++){
            totalcandies+=candies[i];
            maxcandies=Math.max(maxcandies,candies[i]);
        }
        if(totalcandies<k){
            return 0;
        }
        int si=1;
        int ei=maxcandies;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(count(candies,mid,k)){
                si=mid+1;
                res=mid;
            }
            else{
                ei=mid-1;
            }
        }
        return res;
    }
    public boolean count(int[] candies,int mid,long k){
        long count=0;
        for(int j=0;j<candies.length;j++){
            k-=candies[j]/mid;
        }
        return k<=0?true:false;
    }
}