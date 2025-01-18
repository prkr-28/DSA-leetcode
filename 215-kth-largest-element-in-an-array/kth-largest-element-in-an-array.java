class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        if(k==nums.length){
            return pq.peek();
        }
        if(k<nums.length){
            for(int i=k;i<nums.length;i++){
                if(pq.peek()<(nums[i])){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}