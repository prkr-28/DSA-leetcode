class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            while(!st.isEmpty()&&st.peek()==s.charAt(i)){
                st.pop();
                flag=true;
            }
            if(flag==false){
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}