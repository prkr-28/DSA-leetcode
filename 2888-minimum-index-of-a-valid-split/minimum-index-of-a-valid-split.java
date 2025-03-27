class Solution {
    public int minimumIndex(List<Integer> nums) {
        int maj=-1;
        int count=0;

        for(int i=0;i<nums.size();i++){
            if(count==0){
                maj=nums.get(i);
                count=1;
            }
            else if(maj==nums.get(i)){
                count++;
            }
            else{
                count--;
            }
        }

        int majcount=0;
        for(int i:nums){
            if(i==maj){
                majcount++;
            }
        }
        count=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==maj){
                count++;
            }
            int remainingcount=majcount-count;
            int n1=i+1;;
            int n2=nums.size()-i-1;
            if(count>n1/2&&remainingcount>n2/2){
                return i;
            }
        }
        return -1;
    }
}