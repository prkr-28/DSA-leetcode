class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1=word1[0];
        String s2=word2[0];
        for(int i=1;i<word1.length;i++){
            s1+=word1[i];
        }
        for(int i=1;i<word2.length;i++){
            s2+=word2[i];
        }
        char[] s1arr=s1.toCharArray();
        char[] s2arr=s2.toCharArray();
        int maxsize=Math.max(s1arr.length,s2arr.length);
        for(int i=0;i<maxsize;i++){
            if(i<s1arr.length&&i<s2arr.length&&s1arr[i]==s2arr[i]){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}