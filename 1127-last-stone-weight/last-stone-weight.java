class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
        while (pq.size() > 1) {
            int temp = pq.poll();
            int temp2 = pq.poll();

            if (temp != temp2) {
                pq.add(temp - temp2);
            }
        }
        return pq.size()==0?0:pq.peek();
    }
}