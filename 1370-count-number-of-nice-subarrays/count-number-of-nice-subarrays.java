class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int ans=0;
        map.put(0,1);
        for(int i:nums){
            sum+=(i%2==0)?0:1;
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}