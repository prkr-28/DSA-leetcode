class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.add((long)i);
        }
        long res=0;
        while(k>0){
            long tmp=pq.poll();
            res+=tmp;
            pq.add((long)Math.ceil(tmp/3.0));
            k--;
        }
        return res;
    }
}