class Solution {
    int m,n;
    int res;
    int nonobstacle;
    int[] ii={1,0,-1,0};
    int[] jj={0,1,0,-1};
    public int uniquePathsIII(int[][] grid) {
        int count=0;
        nonobstacle=0;
        res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    nonobstacle++;
                }
                if(grid[i][j]==1){
                    m=i;
                    n=j;
                }
            }
        }
        nonobstacle+=1;
        backtrack(grid,m,n,count);
        return res;
    }
    public void backtrack(int[][] grid,int m,int n,int count){
        if(m<0||m>=grid.length||n<0||n>=grid[0].length||grid[m][n]==-1){
            return;
        }
        if(grid[m][n]==2){
            if(count==nonobstacle){
                res++;
            }
            return;
        }
        grid[m][n]=-1;
        for(int i=0;i<4;i++){
            int m_=m+ii[i];
            int n_=n+jj[i];
            backtrack(grid,m_,n_,count+1);
        }
        grid[m][n]=0;
    }
}