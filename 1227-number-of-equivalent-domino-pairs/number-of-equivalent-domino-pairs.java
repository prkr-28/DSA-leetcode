class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n=dominoes.length;
        for(int i=0;i<n;i++){
            if(dominoes[i][0]>dominoes[i][1]){
                int tmp=dominoes[i][0];
                dominoes[i][0]=dominoes[i][1];
                dominoes[i][1]=tmp;
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    res++;
                }
            }
        }
        return res;
    }
}