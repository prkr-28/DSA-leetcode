class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        long res=0;
        int i=0;
        int j=0;
        TreeMap<Integer,Integer>map=new TreeMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            int minele=map.firstKey();
            int maxele=map.lastKey();

            while(i<=j&&maxele-minele>2){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                minele=map.firstKey();
                maxele=map.lastKey();
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
}