class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (int i = 1; i <= 9; i++) {
                        if (issafe(board, row, col, i)) {
                            board[row][col] = (char) ('0' + i);
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean issafe(char[][] board,int row,int col,int digit){
        char ch=(char)('0'+digit);
        for(int i=0;i<=8;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        for(int i=0;i<=8;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        int strow=(row/3)*3;
        int stcol=(col/3)*3;
        for(int i=strow;i<strow+3;i++){
            for(int j=stcol;j<stcol+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}