class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:piles){
            pq.add(i);
        }
        while(k-- >0){
            int temp=pq.poll();
            temp=(int)Math.ceil(temp/2.0);
            pq.add(temp);
        }
        int res=0;
        while(!pq.isEmpty()){
            res+=pq.poll();
        }
        return res;
    }
}