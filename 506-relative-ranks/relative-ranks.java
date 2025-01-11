class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans=new String[score.length];
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        //collections reverse order becz here we have to create a max heap;
        for(int i:score){
            pq.add(i);
        }
        int count=0;
        while(!pq.isEmpty()){
            int temp=pq.peek();
            count++;
            for(int i=0;i<score.length;i++){
                if(score[i]==temp){
                    if(count==1){
                        ans[i]="Gold Medal";
                    }
                    else if(count==2){
                        ans[i]="Silver Medal";
                    }
                    else if(count==3){
                        ans[i]="Bronze Medal";
                    }
                    else{
                        ans[i]=Integer.toString(count);
                    }
                }
            }
            pq.poll();
        }
        return ans;
    }
}