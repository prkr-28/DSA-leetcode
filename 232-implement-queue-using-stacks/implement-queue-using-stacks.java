class MyQueue {
    Stack<Integer>st;
    Stack<Integer>temp;

    public MyQueue() {
        st=new Stack<>();
        temp=new Stack<>();
    }
    
    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
        }else{
            while(!st.isEmpty()){
                temp.push(st.pop());
            }
            st.push(x);
            while(!temp.isEmpty()){
                st.push(temp.pop());
            }
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        if(st.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */