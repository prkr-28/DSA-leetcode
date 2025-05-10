class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int m=(int)1e9+7;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);
        int res=0;
        for(int i=left-1;i<right;i++){
            res=(res+list.get(i))%m;
        }
        return res;
    }
}