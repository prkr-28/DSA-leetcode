class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int si=1;
        int ei=0;
        int ans=0;
        for(int i=0;i<quantities.length;i++){
            ei=Math.max(ei,quantities[i]);
        }
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(distribution(quantities,mid,n)){
                ans=mid;
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return ans;
    }
    public boolean distribution(int[] arr,int mid,int n){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int temp=(int)Math.ceil((double)arr[i]/mid);
            count+=temp;
            if(count>n){
                return false;
            }
        }
        return true;
    }
}