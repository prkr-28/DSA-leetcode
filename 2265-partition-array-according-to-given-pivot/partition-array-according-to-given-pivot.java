class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int start=i;
        int end=j;
        int[] result=new int[n];
        while(i<n&&j>=0){
            if(nums[i]<pivot){
                result[start]=nums[i];
                start++;
            }
            if(nums[j]>pivot){
                result[end]=nums[j];
                end--;
            }
            i++;
            j--;
        }
        for(int m=start;m<=end;m++){
            result[m]=pivot;
        }
        return result;
    }
}