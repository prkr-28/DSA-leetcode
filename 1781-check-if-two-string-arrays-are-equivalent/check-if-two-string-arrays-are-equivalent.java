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
        if(s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }
}