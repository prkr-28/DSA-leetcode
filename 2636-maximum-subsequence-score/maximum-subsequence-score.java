class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] mixarr=new int[n][2];
        for(int i=0;i<n;i++){
            mixarr[i][0]=nums1[i];
            mixarr[i][1]=nums2[i];
        }
        Arrays.sort(mixarr, Comparator.comparingInt((int[] a) -> a[1]).reversed());
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long k_sum=0;
        for(int i=0;i<k;i++){
            pq.add(mixarr[i][0]);
            k_sum+=mixarr[i][0];
        }
        long res=k_sum*mixarr[k-1][1];
        for(int i=k;i<n;i++){
            k_sum=k_sum+mixarr[i][0]-pq.peek();
            pq.poll();
            pq.add(mixarr[i][0]);
            res=Math.max(res,k_sum*mixarr[i][1]);
        }
        return res;
    }
}