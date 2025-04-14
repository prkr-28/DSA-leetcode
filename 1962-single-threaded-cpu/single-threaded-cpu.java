class Pair {
    int processingtym;
    int idx;

    public Pair(int p, int i) {
        this.processingtym = p;
        this.idx = i;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedtask = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedtask[i][0] = tasks[i][0];
            sortedtask[i][1] = tasks[i][1];
            sortedtask[i][2] = i;
        }
        Arrays.sort(sortedtask, Comparator.comparingInt(a -> a[0]));
        List<Integer>res=new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.processingtym == p2.processingtym
                ? Integer.compare(p1.idx, p2.idx)
                : Integer.compare(p1.processingtym, p2.processingtym));
        int currtime = 0;
        int idx = 0;
        while (idx < n || !pq.isEmpty()) {
            if(pq.isEmpty()&&currtime<sortedtask[idx][0]){
                currtime=sortedtask[idx][0];
            }
            while(idx<n&&currtime>=sortedtask[idx][0]){
                pq.add(new Pair(sortedtask[idx][1],sortedtask[idx][2]));
                idx++;
            }

            Pair currtask=pq.poll();
            currtime+=currtask.processingtym;
            res.add(currtask.idx);
        }
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}