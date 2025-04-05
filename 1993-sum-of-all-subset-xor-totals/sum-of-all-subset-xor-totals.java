class Solution {
    List<List<Integer>>list;
    public int subsetXORSum(int[] nums) {
        list=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        subset(nums,0,temp);

        int res=0;
        for(List<Integer>arr:list){
            int xor=0;
            for(int i:arr){
                xor=xor^i;
            }
            res+=xor;
        }
        return res;
    }
    public void subset(int[] nums,int i,List<Integer>temp){
        
        if(i>=nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subset(nums,i+1,temp);
        temp.remove(temp.size()-1);
        subset(nums,i+1,temp);
    }
}