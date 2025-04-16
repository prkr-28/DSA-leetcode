class Solution {
    public long countGood(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int pairs=0;
        long res=0;
        while(j<n){
            if(map.containsKey(nums[j])){
                pairs+=map.get(nums[j]);
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(pairs>=k){
                res+=n-j;
                map.put(nums[i],map.get(nums[i])-1);
                pairs-=map.get(nums[i]);
                i++;
            }
            j++;
        }
        return res;
    }
}