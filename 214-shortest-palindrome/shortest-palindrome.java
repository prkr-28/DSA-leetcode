class Solution {
    public String shortestPalindrome(String s) {
        String str=s;
        String rev=s;
        str=str+'&';
        rev=reverse(rev);
        str=str+rev;
        int pre=lcp(str);
        int temp= s.length()-pre;
        return rev.substring(0,temp)+s;
    }
    public static String reverse(String s){
        StringBuilder reversestring=new StringBuilder(s);
        return reversestring.reverse().toString();
    }
    public static int lcp(String s){
        int length=0;
        int lcp[]=new int[s.length()];
        lcp[0]=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(length)){
                length++;
                lcp[i]=length;
                i++;
            }
            else{
                if(length!=0){
                    length=lcp[length-1];
                }else{
                    lcp[i]=0;
                    i++;
                }
            }
        }
        return length;
    }
}