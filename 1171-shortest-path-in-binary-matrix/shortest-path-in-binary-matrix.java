class Pair{
    int cost;
    int x;
    int y;
    public Pair(int c,int i,int j){
        this.cost=c;
        this.x=i;
        this.y=j;
    }
}

class Solution {
    int[][] dd = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1||grid[n-1][m-1]==1){
            return -1;
        }
        int[][] res=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(1,0,0));
        res[0][0]=1;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int cost=temp.cost;
            int i=temp.x;
            int j=temp.y;

            for(int[] dir:dd){
                int i_=i+dir[0];
                int j_=j+dir[1];

                if(i_>=0&&i_<n&&j_>=0&&j_<m&&grid[i_][j_]==0&&1+cost<res[i_][j_]){
                    res[i_][j_]=1+cost;
                    pq.add(new Pair(res[i_][j_],i_,j_));
                }
            }
        }

        return res[n-1][m-1]==Integer.MAX_VALUE?-1:res[n-1][m-1];
    }
}