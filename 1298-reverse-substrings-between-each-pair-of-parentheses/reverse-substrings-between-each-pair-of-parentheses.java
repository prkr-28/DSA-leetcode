class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(result.length());
            }
            else if(ch==')'){
                int l=st.pop();
                reverse(result,l,result.length()-1);
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}