class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        int bestidx=Integer.MAX_VALUE;
        for(int row=0;row<n;row++){
            int lastidx=0;
            for(int col=0;col<m;col++){
                int val=mat[row][col];
                int idx=map.get(val);
                lastidx=Math.max(lastidx,idx);
            }
            bestidx=Math.min(bestidx,lastidx);
        }
        for(int col=0;col<m;col++){
            int lastidx=0;
            for(int row=0;row<n;row++){
                int val=mat[row][col];
                int idx=map.get(val);
                lastidx=Math.max(lastidx,idx);
            }
            bestidx=Math.min(bestidx,lastidx);
        }
        return bestidx;
    }
}