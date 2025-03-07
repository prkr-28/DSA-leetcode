class Solution {
    public int[] closestPrimes(int left, int right) {
    boolean[] isprime=seiveoferathosesis(right);
        int mindiff=Integer.MAX_VALUE;
        int prev=-1;
        int[] res=new int[]{-1,-1};
        for(int i=left;i<=right;i++){
            if(isprime[i]){
                if(prev==-1){
                    prev=i;
                }
                else{
                    if(i-prev<mindiff){
                        res[0]=prev;
                        res[1]=i;
                        mindiff=i-prev;
                    }
                    prev=i;
                }
            }
        }
        return res;
    }
    public boolean[] seiveoferathosesis(int N){
        boolean[] track=new boolean[N+1];
        Arrays.fill(track,true);
        track[0]=false;
        track[1]=false;
        for(int i=2;i*i<=N;i++){
            if(track[i]==true){
                for(int j=2;i*j<=N;j++){
                    track[i*j]=false;
                }
            }
        }
        return track;
    }
}