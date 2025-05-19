class Solution {
    int[][] dd = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1||grid[n-1][m-1]==1){
            return -1;
        }
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] temp = q.poll();
                int i = temp[0];
                int j = temp[1];
                if (i == n - 1 && j == m - 1) {
                    return count+1;
                }

                for (int[] dir : dd) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];
                    if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && !visited[i_][j_] && grid[i_][j_] == 0) {
                        q.add(new int[] { i_, j_ });
                        visited[i_][j_]=true;
                    }
                }
            }
            count++;
        }

        return -1;
    }
}