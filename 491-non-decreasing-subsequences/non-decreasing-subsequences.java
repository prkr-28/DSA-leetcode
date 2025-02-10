class Solution {
    int n;
    List<List<Integer>>list;
    public List<List<Integer>> findSubsequences(int[] nums) {
        n=nums.length;
        list=new ArrayList<>();
        List<Integer>arr=new ArrayList<>();
        backtrack(nums,0,arr);
        return list;
    }
    public void backtrack(int[] nums,int idx,List<Integer>arr){
        if(arr.size()>1){
            list.add(new ArrayList<>(arr));
        }

        Set<Integer>set=new HashSet<>();
        for(int i=idx;i<n;i++){
            if((arr.size()==0||nums[i]>=arr.get(arr.size()-1))&&!set.contains(nums[i])){
                set.add(nums[i]);
                arr.add(nums[i]);
                backtrack(nums,i+1,arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}