class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int sz=arr.size();
        int target=arr.get(sz/2);
        int res=0;
        for(int i=0;i<sz;i++){
            if((target%x)!=(arr.get(i)%x)){
                return -1;
            }
            res+=Math.abs(target-arr.get(i))/x;
        }
        return res;
    }
}