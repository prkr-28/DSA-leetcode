class Solution {
    public boolean isPalindrome(int x) {
        int revno=0;
        int temp=x;
        while(x>0){
            int r=x%10;
            revno=(revno*10)+r;
            x=x/10;
        }
        if(revno==temp){
            return true;
        }else{
            return false;
        }
    }
}