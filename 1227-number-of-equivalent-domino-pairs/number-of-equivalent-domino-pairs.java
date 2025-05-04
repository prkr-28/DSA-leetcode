class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n=dominoes.length;
        int res=0;
        int[] freq=new int[100];
        Arrays.fill(freq,0);
        for(int i=0;i<n;i++){
            if(dominoes[i][0]>dominoes[i][1]){
                int tmp=dominoes[i][0];
                dominoes[i][0]=dominoes[i][1];
                dominoes[i][1]=tmp;
            }
            int a=dominoes[i][0];
            int b=dominoes[i][1];
            int num=a*10+b;
            res+=freq[num];
            freq[num]++;
        }
        return res;
    }
}