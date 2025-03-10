class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long[] result=new long[n];
        int[][] temp=new int[n][3];
        for(int i=0;i<n;i++){
            temp[i][0]=nums1[i];
            temp[i][1]=i;
            temp[i][2]=nums2[i];
        }
        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));
        long sum=0;
        for(int i=0;i<n;i++){
            if(i>0&&temp[i][0]==temp[i-1][0]){
                long a=result[temp[i-1][1]];
                result[temp[i][1]]=a;
            }
            else{
                result[temp[i][1]]=sum;
            }
            pq.add(temp[i][2]);
            sum+=temp[i][2];
            if(pq.size()>k){
                sum-=pq.peek();
                pq.poll();
            }
        }
        return result;
    }
}