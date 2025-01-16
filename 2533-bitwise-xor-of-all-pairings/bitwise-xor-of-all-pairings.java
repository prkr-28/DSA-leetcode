class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+nums2.length);
        }
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+nums1.length);
        }
        for(int i:map.keySet()){
            if(map.get(i)%2!=0){
                ans^=i;
            }
        }
        return ans;
    }
}