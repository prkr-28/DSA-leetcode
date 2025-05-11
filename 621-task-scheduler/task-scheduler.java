class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int time=0;
        for(char ch:tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:freq){
            if(i>0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            List<Integer>list=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int temp=pq.poll();
                    temp--;
                    list.add(temp);
                }
            }

            for(int ele:list){
                if(ele>0){
                    pq.add(ele);
                }
            }

            if(!pq.isEmpty()){
                time+=n+1;
            }
            else{
                time+=list.size();
            }
        }
        return time;
    }
}