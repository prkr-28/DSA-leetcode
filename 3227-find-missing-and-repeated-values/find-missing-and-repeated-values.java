class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr.add(grid[i][j]);
            }
        }
        
        int[] hash = new int[arr.size() + 1];
        int repeating = -1;
        int missing = -1;
        
        for (int num : arr) {
            hash[num]++;
        }
        
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                missing = i;
            } else if (hash[i] == 2) {
                repeating = i;
            }
            if (missing != -1 && repeating != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }
}