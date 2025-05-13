class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod=(int)1e9+7;
        int[] map=new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
        }

        for(int c=1;c<=t;c++){
            int[] temp=new int[26];
            for(int i=0;i<26;i++){
                char ch=(char)(i+'a');
                int freq=map[i];
                if(ch!='z'){
                    temp[(ch+1)-'a']=(temp[(ch+1)-'a']+freq)%mod;
                }
                else{
                    temp['a'-'a']=(temp['a'-'a']+freq)%mod;
                    temp['b'-'a']=(temp['b'-'a']+freq)%mod;
                }
            }
            map=temp;
        }

        int res=0;
        for(int i=0;i<26;i++){
            res=(res+map[i])%mod;
        }
        return res;
    }
}