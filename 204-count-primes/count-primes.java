class Solution {
    public int countPrimes(int n) {
        int[] box=new int[n+1];
        for(int i=2;i<box.length;i++){
            box[i]=1;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(box[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    box[j]=0;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(box[i]==1){
                count++;
            }
        }
        return count;
    }
}