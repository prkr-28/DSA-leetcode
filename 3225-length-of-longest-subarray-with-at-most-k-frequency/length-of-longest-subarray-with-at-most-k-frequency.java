class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int maxsize=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(i<=j&&map.get(nums[j])>k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            maxsize=Math.max(maxsize,j-i+1);
            j++;
        }
        return maxsize;
    }
}