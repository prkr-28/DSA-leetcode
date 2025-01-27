class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>s=new Stack<>();
        int[] ans=new int[temperatures.length];
        int n=temperatures.length;
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=s.peek()-i;
            }
            s.push(i);
        }
        return ans;
    }
}