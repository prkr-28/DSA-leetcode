class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer>mp1=new HashMap<>();
        Map<Integer,Integer>mp2=new HashMap<>();

        for(int i:nums){
            mp2.put(i,mp2.getOrDefault(i,0)+1);
        }

        for(int i=0;i<nums.size();i++){
            int num=nums.get(i);

            mp1.put(num,mp1.getOrDefault(num,0)+1);
            mp2.put(num,mp2.get(num)-1);

            int n1=i+1;
            int n2=nums.size()-i-1;

            if(mp1.get(num)>n1/2&&mp2.get(num)>n2/2){
                return i;
            }
        }
        return -1;
    }
}