class Solution {
    public int countNicePairs(int[] nums) {
        long n=nums.length;
        long  count=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int m=rev(nums[i])-nums[i];
            map.put(m,map.getOrDefault(m,0)+1);
        }

        for(int num:map.values()){
            if(num>1){
                count+=((long)num*(num-1))/2;
            }
        }

        return (int)(count % (int)(1e9 + 7));

    }

    public int rev(int num){
        int revnum=0;
        while(num>0){
            int rem=num%10;
            revnum=revnum*10+rem;
            num=num/10;
        }
        return revnum;
    }
}