class Solution {
    public int repeatedStringMatch(String a, String b) {
        int maxcnt=1;
        int n=a.length();
        int m=b.length();
        String temp=a;
        while(n<m){
            a+=temp;
            maxcnt++;
            n=a.length();
        }
        if(a.contains(b)){
            return maxcnt;
        }
        a+=temp;
        maxcnt++;
        if(a.contains(b)){
            return maxcnt;
        }
        return -1;
    }
}