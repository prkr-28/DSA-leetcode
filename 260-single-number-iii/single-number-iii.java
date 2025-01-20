class Solution {
    public int[] singleNumber(int[] nums) {
        int[] list=new int[2];
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }
        int mask=xor&(-xor);
        int a=0;
        int b=0;
        for(int i:nums){
            if((mask&i)==0){
                a=a^i;
            }else{
                b=b^i;
            }
        }
        list[0]=a;
        list[1]=b;
        return list;
    }
}