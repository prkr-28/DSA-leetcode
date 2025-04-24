class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        int count=0;
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        for(int i=0;i<n;i++){
            Set<Integer>tempset=new HashSet<>();
            for(int j=i;j<n;j++){
                tempset.add(nums[j]);
                if(tempset.size()==set.size()){
                    count++;
                }
            }
        }
        return count;
    }
}