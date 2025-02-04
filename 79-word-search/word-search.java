class Solution {
    int[] ii={-1,0,1,0};
    int[] jj={0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[n][m];
                    if(isfound(board,i,j,0,visited,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isfound(char[][] board,int i,int j,int idx,boolean[][] visited,String word){
        if(idx==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(idx))  {
            return false;
        }

        visited[i][j]=true;
        boolean temp=false;
        for(int k=0;k<4;k++){
            int i_=i+ii[k];
            int j_=j+jj[k];
            if(isfound(board,i_,j_,idx+1,visited,word)){
                temp=true;
                break;
            }
        }
        if(temp==true){
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}