class Solution {
    int[][] dd = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int q=queries.length;
        int[] res = new int[q];
        int[][] sortedQ = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
        }
        Arrays.sort(sortedQ, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(queries);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;
        for (int i[] : sortedQ) {
            int val=i[0];
            int idx=i[1];
            while (!pq.isEmpty() && pq.peek()[0] < val) {
                int[] temp = pq.poll();
                int x = temp[1];
                int y = temp[2];
                ans++;
                for (int[] dir : dd) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
                    if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n && visited[x_][y_] == false) {
                        pq.add(new int[] { grid[x_][y_], x_, y_ });
                        visited[x_][y_] = true;
                    }
                }
            }
            res[idx] = ans;
        }
        return res;
    }
}