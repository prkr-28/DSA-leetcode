class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer,Integer>rowpos=new HashMap<>();
        Map<Integer,Integer>colpos=new HashMap<>();
        int[] rowcount=new int[n];
        int[] colcount=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rowpos.put(mat[i][j],i);
                colpos.put(mat[i][j],j);
            }
        }
        for(int i=0;i<arr.length;i++){
            int v=arr[i];
            rowcount[rowpos.get(v)]++;
            colcount[colpos.get(v)]++;
            if(rowcount[rowpos.get(v)]==m||colcount[colpos.get(v)]==n){
                return i;
            }
        }
        return -1;
    }
}