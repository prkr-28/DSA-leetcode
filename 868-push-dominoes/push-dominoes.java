class Solution {
    //two pointer method...
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        int[] leftclosestR=new int[n];
        int[] rightclosestL=new int[n];

        //move from left to right...to fill leftclosesttoR..
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                leftclosestR[i]=i;
            }
            else if(dominoes.charAt(i)=='.'){
                leftclosestR[i]=i>0?leftclosestR[i-1]:-1;
            }
            else{
                leftclosestR[i]=-1;
            }
        }
        //move from right to left...to fill rightclosesttoL..
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                rightclosestL[i]=i;
            }
            else if(dominoes.charAt(i)=='.'){
                rightclosestL[i]=i<n-1?rightclosestL[i+1]:-1;
            }
            else{
                rightclosestL[i]=-1;
            }
        }

        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            int distleftR=Math.abs(i-leftclosestR[i]);
            int distrightL=Math.abs(i-rightclosestL[i]);
            if(leftclosestR[i]==rightclosestL[i]){
                res.append('.');
            }
            else if(rightclosestL[i]==-1){
                res.append('R');
            }
            else if(leftclosestR[i]==-1){
                res.append('L');
            }
            else if(distleftR==distrightL){
                res.append('.');
            }
            else{
                char temp=distleftR<distrightL?'R':'L';
                res.append(temp);
            }
        }
        return res.toString();
    }
}