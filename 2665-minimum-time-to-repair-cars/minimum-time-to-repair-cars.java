class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max=-1;
        for(int num:ranks){
            max=Math.max(num,max);
        }
        long si=0;
        long ei=(long)(max*cars*cars);
        while(si<=ei){
            long mid=si+(ei-si)/2;
            if(isthis_timeSufficient(ranks,cars,mid)){
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return si;
    }
    public boolean isthis_timeSufficient(int[] nums,int cars,long mid){
        long carrepaired=0;
        for(int i=0;i<nums.length;i++){
            long c=mid/nums[i];
            long car=(long)Math.sqrt(c);
            carrepaired+=car;
        }
        return (carrepaired>=cars);
    }
}