class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int i:nums){
            if(countdigits(i)%2==0){
                res++;
            }
        }
        return res;
    }
    public int countdigits(int num){
        int count=0;
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
}