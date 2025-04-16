class Pair{
    int value;
    int row;
    int col;
    public Pair(int v,int r,int c){
        this.value=v;
        this.row=r;
        this.col=c;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        for(int i=0;i<Math.min(n,k);i++){
            pq.add(new Pair(matrix[i][0],i,0));
        }

        for(int i=0;i<k-1;i++){
            Pair tmp=pq.poll();
            int val=tmp.value;
            int r=tmp.row;
            int c=tmp.col;
            if(c+1<n){
                pq.add(new Pair(matrix[r][c+1],r,c+1));
            }
        }
        return pq.poll().value;
    }
}