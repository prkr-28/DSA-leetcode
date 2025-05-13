class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        int count=0;
        int prevend=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<prevend){
                count++;
                prevend=Math.min(prevend,intervals[i][1]);
            }
            else{
                prevend=Math.max(prevend,intervals[i][1]);
            }
        }
        return count;
    }
}