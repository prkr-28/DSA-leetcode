class Solution {
    public int sumSubarrayMins(int[] arr) {
        long maxscore = 0;
        int mod=1000000007;
        int n=arr.length;
        int[] nsl=getnsl(arr,n);
        int[] nsr=getnsr(arr,n);
        for (int i = 0; i < n; i++) {
            long d1=i-nsl[i];
            long d2=nsr[i]-i;
            maxscore=(maxscore+(d1*d2*arr[i]))%mod;
        }
        return (int)maxscore;
    }
    public static int[] getnsl(int[] arr,int n){
        int[] result=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            result[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return result;
    }
    public int[] getnsr(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }
}