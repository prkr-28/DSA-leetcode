class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int cnless=0;
        int cnequal=0;
        for(int l=0;l<nums.length;l++){
            if(nums[l]<pivot){
                cnless++;
            }
            else if(nums[l]==pivot){
                cnequal++;
            }
        }
        int i=0;
        int j=cnless;
        int k=cnequal+cnless;
        int[] result=new int[nums.length];
        for(int m=0;m<nums.length;m++){
            if(nums[m]<pivot){
                result[i]=nums[m];
                i++;
            }
            else if(nums[m]>pivot){
                result[k]=nums[m];
                k++;
            }
            else{
                result[j]=nums[m];
                j++;
            }
        }
        return result;
    }
}