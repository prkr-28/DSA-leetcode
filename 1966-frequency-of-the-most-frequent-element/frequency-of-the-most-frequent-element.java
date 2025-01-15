class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int result=Integer.MIN_VALUE;
        int[] prefixsum=new int[nums.length];
        prefixsum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixsum[i]=prefixsum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int freq=bsearch(i,nums,k,prefixsum);
            result=Math.max(result,freq);
        }
        return result;
    }
    public static int bsearch(int i,int[] nums,int k,int[] prefixsum){
        int l=0;
        int r=i;
        int res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=(i-mid+1);
            int winsum=count*nums[i];
            int originalsum=prefixsum[i]-prefixsum[mid]+nums[mid];
            int oper=winsum-originalsum;
            if(oper>k){
                l=mid+1;
            }
            else{
                res=mid;
                r=mid-1;
            }
        }
        return i-res+1;
    }

    // public static int sum(int[] nums,int si,int ei){
    //     int sum=0;
    //     for(int i=si;i<=ei;i++){
    //         sum+=nums[i];
    //     }
    //     return sum;
    // }
}