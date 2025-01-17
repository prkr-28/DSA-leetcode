class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor){
            return 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return (-1)*Integer.MAX_VALUE;
        }
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        int max=Integer.MAX_VALUE;
        boolean sign=true;
        if(divisor<0&&dividend>0||divisor>0&&dividend<0){
            sign=false;
        }
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans=0;
        while(n>=d){
            int count=0;
            while(n>=(d<<(count+1))){
                count++;
            }
            ans+=(1<<count);
            n=n-d*(1<<count);
        }
        if(ans>=max&&sign==true){
            return max;
        }
        if(ans>=max&&sign==false){
            return Integer.MIN_VALUE;
        }
        return (sign)==true?ans:(-1)*ans;
    }
}