class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            int num=asteroids[i];
            while(!st.isEmpty()&&num<0&&st.peek()>0){
                int sum=st.peek()+num;
                if(sum<0){
                    st.pop();
                }
                else if(sum>0){
                    num=0;
                    break;
                }
                else{
                    st.pop();
                    num=0;
                    break;
                }
            }
            if(num!=0){
                st.push(num);
            }
        }
        int sz=st.size();
        int[] ans=new int[sz];
        int i=sz-1;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return ans;

    }
}