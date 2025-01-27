class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        StringBuilder result=new StringBuilder();
        int n=num.length();
        Stack<Character>s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&k>0&&s.peek()-'0'>num.charAt(i)-'0'){
                s.pop();
                k--;
            }
            if(s.size()>0||num.charAt(i)!='0'){
                s.push(num.charAt(i));
            }
        }
        while(!s.isEmpty()&&k>0){
            s.pop();
            k--;
        }
        if(s.isEmpty()){
            return "0";
        }
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        result=result.reverse();
        return result.toString();
    }
}