class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int k=set.size();
        int count=0;
        int i=0;
        int j=0;
        Map<Integer,Integer>map=new HashMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==k&&i<n){
                count+=n-j;
                map.put(nums[i],map.get(nums[i])-1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}