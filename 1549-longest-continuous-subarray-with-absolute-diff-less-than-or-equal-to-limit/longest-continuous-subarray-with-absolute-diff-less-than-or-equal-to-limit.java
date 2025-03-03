class Pair{
    int first;
    int second;
    public Pair(int f,int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair>minheap=new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        PriorityQueue<Pair>maxheap=new PriorityQueue<>((a, b) -> Integer.compare(b.first, a.first));
        int i=0;
        int j=0;
        int maxlength=0;
        while(j<nums.length){
            minheap.add(new Pair(nums[j],j));
            maxheap.add(new Pair(nums[j],j));
            while(maxheap.peek().first-minheap.peek().first>limit){
                i=Math.min(maxheap.peek().second,minheap.peek().second)+1;
                while(maxheap.peek().second<i){
                    maxheap.poll();
                }
                while(minheap.peek().second<i){
                    minheap.poll();
                }
            }
            maxlength=Math.max(maxlength,j-i+1);
            j++;
        }
        return maxlength;
    }
}