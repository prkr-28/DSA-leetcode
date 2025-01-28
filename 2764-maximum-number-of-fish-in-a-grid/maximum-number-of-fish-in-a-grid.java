class Solution {
    private int m, n;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int bfs(int i, int j, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int fishCount = grid[i][j];
        grid[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            i = cell[0];
            j = cell[1];

            for (int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] > 0) {
                    queue.offer(new int[]{i_, j_});
                    fishCount += grid[i_][j_];
                    grid[i_][j_] = 0;
                }
            }
        }

        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) { // water cell found
                    maxFish = Math.max(maxFish, bfs(i, j, grid));
                }
            }
        }

        return maxFish;
    }
}