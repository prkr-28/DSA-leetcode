class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int si=matrix[0][0];
        int ei=matrix[n-1][n-1];;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(countsmaller(mid,matrix)<=k-1){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return si;
    }
    public int countsmaller(int target,int[][] matrix){
        int totalcount=0;
        for(int i=0;i<matrix.length;i++){
            int si=0;
            int ei=matrix[i].length-1;
            while(si<=ei){
                int mid=si+(ei-si)/2;
                if(matrix[i][mid]<=target){
                    si=mid+1;
                }
                else{
                    ei=mid-1;
                }
            }
            totalcount+=si;
        }
        return totalcount;
    }
}