class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] horizontal=new int[rectangles.length][2];
        int[][] vertical=new int[rectangles.length][2];

        for(int i=0;i<rectangles.length;i++){
            horizontal[i][0]=rectangles[i][1];
            horizontal[i][1]=rectangles[i][3];
            vertical[i][0]=rectangles[i][0];
            vertical[i][1]=rectangles[i][2];
        }

        int[][] mergedhorizontal=mergeinterval(horizontal);
        int[][] mergedvertical=mergeinterval(vertical);
        return mergedhorizontal.length>=3||mergedvertical.length>=3;
    }
    public int[][] mergeinterval(int[][] intervals){
        int n=intervals.length;
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]>merged=new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] <= interval[0]) {
                merged.add(interval); // Add interval if it doesn't overlap.
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]); // Merge intervals.
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}