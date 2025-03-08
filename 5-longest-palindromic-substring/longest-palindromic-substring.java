class Solution {
    public String longestPalindrome(String s) {
        int maxlen=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            //odd length...
            String curr=helper(s,i,i);
            if(curr.length()>maxlen){
                maxlen=curr.length();
                ans=curr;
            }
            //even length...
            curr=helper(s,i,i+1);
            if(curr.length()>maxlen){
                maxlen=curr.length();
                ans=curr;
            }
        }
        return ans;
    }
    public String helper(String s,int i,int j){
        while(i>=0&&j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }
        }
        return s.substring(i+1,j);
    }
}