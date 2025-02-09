class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long t_pairs=(n*(n-1))/2;
        long goodpairs=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
        }
        for (int count : map.values()) {
            if (count > 1) {
                goodpairs += ((long) count * (count - 1)) / 2;
            }
        }

        return t_pairs-goodpairs;
    }
}