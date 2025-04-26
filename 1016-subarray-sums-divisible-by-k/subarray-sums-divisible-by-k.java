class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<>();
        mp.put(0,1);
        int res=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0){
                rem+=k;
            }
            if(mp.containsKey(rem)){
                res+=mp.get(rem);
            }
            mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return res;
    }
}