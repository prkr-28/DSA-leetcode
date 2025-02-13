class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        int count=0;
        while(pq.size()>1&&pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            long newele = x * 2 + y;
            pq.add(newele);
            count++;
        }
        return pq.peek()>=k?count:-1;
    }
}