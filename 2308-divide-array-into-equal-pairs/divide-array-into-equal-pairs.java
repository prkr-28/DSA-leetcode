class Solution {
    public boolean divideArray(int[] nums) {
        int sz=nums.length;
        int n=sz/2;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<sz;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i:map.keySet()){
            int temp=map.get(i);
            if(temp%2!=0){
                return false;
            }
        }
        return true;
    }
}