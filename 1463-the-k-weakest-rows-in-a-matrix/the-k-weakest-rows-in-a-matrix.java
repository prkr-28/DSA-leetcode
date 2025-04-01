class Pair {
    int sum;
    int idx;

    Pair(int sum, int idx) {
        this.sum = sum;
        this.idx = idx;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((p1,p2)->p1.sum==p2.sum?Integer.compare(p1.idx,p2.idx):Integer.compare(p1.sum,p2.sum));

        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j:mat[i]){
                sum+=j;
            }
            pq.add(new Pair(sum,i));
        }

        int[] ans=new int[k];
        int i=0;
        while(k>0){
            ans[i]=pq.poll().idx;
            i++;
            k--;
        }
        return ans;
    }
}