class Solution {
    public boolean parseBoolExpr(String expression) {
        int n=expression.length();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=expression.charAt(i);
            if(ch==','){
                continue;
            }
            if(ch==')'){
                List<Character>list=new ArrayList<>();
                while(st.peek()!='('){
                    list.add(st.peek());
                    st.pop();
                }
                st.pop();
                char operator=st.pop();
                st.push(solve(list,operator));
            }
            else{
                st.push(ch);
            }
        }
        return st.peek()=='t'?true:false;
    }
    public static char solve(List<Character>list,char ch){
        if(ch=='!'){
            return list.get(0)=='t'?'f':'t';
        }
        if(ch=='|'){
            for(char c:list){
                if(c=='t'){
                    return 't';
                }
            }
            return 'f';
        }
        if(ch=='&'){
            for(char c:list){
                if(c=='f'){
                    return 'f';
                }
            }
            return 't';
        }
        return 't';
    }
}