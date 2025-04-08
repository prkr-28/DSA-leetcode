class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        for(i=nums.length-1;i>=0;i--){
            int num=nums[i];
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else{
                i++;
                break;
            }
        }
        return (int)Math.ceil(i/3.0);
    }
}