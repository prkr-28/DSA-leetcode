class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        Set<Integer>set=new HashSet<>();
        set.add(n);
        while(true){
            int sum=0;
            while(n>0){
                sum+=Math.pow((n%10),2);
                n=n/10;
            }
            if(sum==1){
                return true;
            }
            n=sum;
            if(set.contains(n)){
                return false;
            }
            else{
                set.add(n);
            }
        }
    }
}