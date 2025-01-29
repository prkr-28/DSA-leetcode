class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        Stack<Character>st=new Stack<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(!st.isEmpty()&&st.peek()=='b'&&s.charAt(i)=='a'){
                count++;
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return count;
    }
}