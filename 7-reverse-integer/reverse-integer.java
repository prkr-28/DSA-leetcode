class Solution {
    public int reverse(int x) {
        long revno=0;
        if(x<0){
            x=x*-1;
            while(x>0){
                int r=x%10;
                revno=(revno*10)+r;
                x=x/10;
            }
            return (revno< Integer.MIN_VALUE|| revno> Integer.MAX_VALUE) ? 0 : (int)(-1*revno);
        }
        else{
            while(x>0){
                int r=x%10;
                revno=(revno*10)+r;
                x=x/10;
            }
            return (revno< Integer.MIN_VALUE|| revno> Integer.MAX_VALUE) ? 0 :(int) revno;
        }
    }
}