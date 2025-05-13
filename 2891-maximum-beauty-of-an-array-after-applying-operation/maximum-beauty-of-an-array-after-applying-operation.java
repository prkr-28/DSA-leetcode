class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int[][] intervals=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            intervals[i][0]=nums[i]-k;
            intervals[i][1]=nums[i]+k;
        }

        Arrays.sort(intervals,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(intervals[0]);
        for(int i=1;i<nums.length;i++){
            int[] temp=pq.peek();
            if(intervals[i][0]>temp[1]){
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}