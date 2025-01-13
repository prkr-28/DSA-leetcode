class Solution {
    public String longestPrefix(String s) {
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
        return s.substring(0,length);
    }
}