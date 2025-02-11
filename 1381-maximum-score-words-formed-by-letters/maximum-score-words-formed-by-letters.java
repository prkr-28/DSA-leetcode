class Solution {
    int maxscore;
    int n;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        n=words.length;
        maxscore=Integer.MIN_VALUE;
        int currscore=0;
        int[] freq=new int[26];
        Arrays.fill(freq,0);
        for(char ch: letters){
            freq[ch-'a']++;
        }
        solve(0,score,words,currscore,freq);
        return maxscore;
    }
    public void solve(int idx,int[] score,String[] words,int currscore,int[] freq){
        maxscore=Math.max(maxscore,currscore);
        if(idx==n){
            return;
        }
        //can we take words[i]..
        int j=0;
        int tempscore=0;
        int[] tempfreq = Arrays.copyOf(freq, freq.length);
        while(j<words[idx].length()){
            char ch=words[idx].charAt(j);
            tempfreq[ch-'a']--;
            tempscore+=score[ch-'a'];
            if(tempfreq[ch-'a']<0){
                break;
            }
            j++;
        }
        //take..
        if(j==words[idx].length()){
            solve(idx+1,score,words,currscore+tempscore,tempfreq);
        }
        //not take..
        solve(idx+1,score,words,currscore,freq);
    }
}