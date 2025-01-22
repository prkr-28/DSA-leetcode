class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    int[] ii={0,-1,0,1};
    int[] jj={-1,0,1,0};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Initialize the queue and answer array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new Pair(i, j));
                } else {
                    ans[i][j] = -1; // Mark as unvisited
                }
            }
        }

        int level = 1;
        // BFS traversal
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                Pair p = q.poll();
                int i = p.i;
                int j = p.j;
                for (int k = 0; k < 4; k++) {
                    int newi = i + ii[k];
                    int newj = j + jj[k];
                    if (isvalid(newi, newj, n, m) && ans[newi][newj] == -1) {
                        ans[newi][newj] = level;
                        q.add(new Pair(newi, newj));
                    }
                }
                size--;
            }
            level++;
        }

        return ans;
    }

    public static boolean isvalid(int i,int j, int n,int m){
        return (i >= 0 && i < n) && (j >= 0 && j < m);
    }
}