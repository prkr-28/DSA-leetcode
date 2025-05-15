class Solution {
    public long countSubstrings(String s, char c) {
        long[] freq=new long[26];
        int n=s.length();
        long count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c&&freq[s.charAt(i)-'a']!=0){
                count+=freq[s.charAt(i)-'a'];
            }
            freq[s.charAt(i)-'a']++;
        }
        return count+freq[c-'a'];
    }
}