class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        fast=gethappy(gethappy(fast));
        while(slow!=fast){
            slow=gethappy(slow);
            fast=gethappy(gethappy(fast));
        }
        if(slow==1){
            return true;
        }
        else{
            return false;
        }
    }
    public int gethappy(int n){
        int sum=0;
        while(n>0){
            sum+=Math.pow((n%10),2);
            n=n/10;
        }
        return sum;
    }
}