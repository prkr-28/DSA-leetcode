class Solution {
    static List<List<String>>list;
    public List<List<String>> solveNQueens(int n) {
        list=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,0);
        return list;
    }
    public static void solve(char[][] board,int row){
        int n=board.length;
        if(board.length==row){
            store(board);
            return;
        }
        for(int i=0;i<n;i++){
            if(issafe(board,row,i)){
                board[row][i]='Q';
                solve(board,row+1);
                board[row][i]='.';
            }
        }
    }
    public static boolean issafe(char[][] board,int r,int c){
        //up dire...
        for(int row=r-1;row>=0;row--){
            if(board[row][c]=='Q'){
                return false;
            }
        }
        //left diag...
        for(int row=r-1,col=c-1;row>=0&&col>=0;row--,col--){
            if(board[row][col]=='Q'){
                return false;
            }
        }
        //right diag...
        for(int row=r-1,col=c+1;row>=0&&col<board.length;row--,col++){
            if(board[row][col]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void store(char[][] board){
        int sz=board.length;
        List<String>arr=new ArrayList<>();
        for(int i=0;i<sz;i++){
            String s="";
            for(int j=0;j<sz;j++){
                s=s+board[i][j];
            }
            arr.add(s);
        }
        list.add(arr);
    }
}