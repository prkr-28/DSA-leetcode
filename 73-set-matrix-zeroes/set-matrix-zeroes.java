class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        boolean isfirstcolzero=false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    if(j==0){
                        isfirstcolzero=true;
                    }
                    else{
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<c;i++){
                matrix[0][i]=0;
            }
        }
        if(isfirstcolzero){
            for(int j=0;j<r;j++){
                matrix[j][0]=0;
            }
        }
    }
}