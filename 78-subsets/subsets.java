class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>>list=new ArrayList<>();
        int subsets=(1<<n);
        for(int i=0;i<subsets;i++){
            List<Integer>ans=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    ans.add(nums[j]);
                }
            }
            list.add(ans);
        }
        return list;
    }
}