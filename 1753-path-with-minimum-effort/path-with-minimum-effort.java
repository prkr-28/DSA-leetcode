class Pair{
    int diff;
    int x;
    int y;
    public Pair(int d,int x,int y){
        this.diff=d;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    int[][] dd={{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] res=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.diff,b.diff));
        pq.add(new Pair(0,0,0));
        res[0][0]=0;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int diff=temp.diff;
            int i=temp.x;
            int j=temp.y;

            if(i==n-1&&j==m-1){
                return diff;
            }

            for(int[] dir:dd){
                int i_=i+dir[0];
                int j_=j+dir[1];

                if(i_>=0&&i_<n&&j_>=0&&j_<m){
                    int diff_=Math.abs(heights[i_][j_]-heights[i][j]);
                    int maxdiff=Math.max(diff,diff_);
                    if(maxdiff<res[i_][j_]){
                        res[i_][j_]=maxdiff;
                        pq.add(new Pair(res[i_][j_],i_,j_));
                    }
                }
            }
        }

        return res[n-1][m-1];
    }
}