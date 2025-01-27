class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        if(st.isEmpty()){
            return "";
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb=sb.reverse();
        return sb.toString();
    }
}