class Solution {
    public long gridGame(int[][] grid) {
        long firstrowsum=0;
        for(int i=0;i<grid[0].length;i++){
            firstrowsum+=grid[0][i];
        }
        long firstrowremainingsum=firstrowsum;
        long secondrowsum=0;
        long maxpoints=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            firstrowremainingsum-=grid[0][i];
            maxpoints=Math.min(maxpoints,Math.max(firstrowremainingsum,secondrowsum));
            secondrowsum+=grid[1][i];
        }
        return maxpoints;
    }
}