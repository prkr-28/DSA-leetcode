class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int ans=0;
        int n=nums.length;
        Arrays.sort(queries,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>candidates=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>choosen_cd=new PriorityQueue<>();
        int j=0;
        for(int i=0;i<n;i++){
            while(j<queries.length&&queries[j][0]==i){
                candidates.add(queries[j][1]);
                j++;
            }
            nums[i]-=choosen_cd.size();
            while(nums[i]>0&&!candidates.isEmpty()&&candidates.peek()>=i){
                choosen_cd.add(candidates.poll());
                ans++;
                nums[i]--;
            }
            if(nums[i]>0){
                return -1;
            }
            while(!choosen_cd.isEmpty()&&choosen_cd.peek()<=i){
                choosen_cd.poll();
            }
        }

        return queries.length-ans;
    }
}