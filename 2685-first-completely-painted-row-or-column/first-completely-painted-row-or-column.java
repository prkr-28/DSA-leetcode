class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[] map = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = i;
        }

        int bestidx=Integer.MAX_VALUE;
        for(int row=0;row<n;row++){
            int lastidx=0;
            for(int col=0;col<m;col++){
                int val=mat[row][col];
                int idx=map[val];
                lastidx=Math.max(lastidx,idx);
            }
            bestidx=Math.min(bestidx,lastidx);
        }
        for(int col=0;col<m;col++){
            int lastidx=0;
            for(int row=0;row<n;row++){
                int val=mat[row][col];
                int idx=map[val];
                lastidx=Math.max(lastidx,idx);
            }
            bestidx=Math.min(bestidx,lastidx);
        }
        return bestidx;
    }
}