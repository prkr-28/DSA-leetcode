class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>list=new ArrayList<>();
        generate(n,0,list,"");
        return list;
    }
    public static void generate(int n,int length,List<String>list,String str){
        if(str.length()==2*n){
            if(isvalid(str)){
                list.add(str);
            }
            return;
        }
        str+='(';
        generate(n,length+1,list,str);
        str=str.substring(0,str.length()-1);
        str+=')';
        generate(n,length+1,list,str);
    }
    public static boolean isvalid(String s){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek()=='('&&ch==')'
                ||st.peek()=='{'&&ch=='}'
                ||st.peek()=='['&&ch==']'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}