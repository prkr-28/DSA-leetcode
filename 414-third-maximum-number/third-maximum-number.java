class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(set);
        if(pq.size()<3){
            return pq.peek();
        }else{
            pq.poll();
            pq.poll();
        }
        return pq.peek();
    }
}