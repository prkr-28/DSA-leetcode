class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer>open=new Stack<>();
        Stack<Integer>openclose=new Stack<>();
        int n = s.length();
        if(n%2==1) return false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(locked.charAt(i)=='0'){
                openclose.push(i);
            }
            else if(ch==')'){
                if(!open.isEmpty()){
                    open.pop();
                }else{
                    if(!openclose.isEmpty()){
                        if(openclose.peek()<i){
                            openclose.pop();
                        }
                    }else{
                        return false;
                    }
                }
            }
            else{
                open.push(i);
            }
        }
        while(!open.isEmpty()&&!openclose.isEmpty()){
            if(open.peek()>openclose.peek()){
                return false;
            }
            else{
                open.pop();
                openclose.pop();
            }
        }
        if(!open.isEmpty()){
            return false;
        }
        return true;
    }
}