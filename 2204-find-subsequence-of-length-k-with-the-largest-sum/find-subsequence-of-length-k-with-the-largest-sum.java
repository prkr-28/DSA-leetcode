class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
            if(pq.size()>k){
                pq.poll();
            }
        }

        ArrayList<int[]>arr=new ArrayList<>(pq);
        arr.sort(Comparator.comparingInt(a->a[1]));

        int ans[]=new int[k];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i)[0];
        }
        return ans;
    }
}