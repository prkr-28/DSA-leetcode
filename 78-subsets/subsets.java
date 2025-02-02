class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> subsets(int[] nums) {
        list=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        subset(nums,0,temp);
        return list;
    }
    public void subset(int[] nums,int i,List<Integer>temp){
        
        if(i>=nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subset(nums,i+1,temp);
        temp.remove(temp.get(temp.size()-1));
        subset(nums,i+1,temp);
    }
}