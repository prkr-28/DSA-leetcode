class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        int count=0;
        int e=0;
        for(int i=0;i<meetings.length;i++){
            if(meetings[i][0]>e){
                count+=meetings[i][0]-e-1;
            }
            e=Math.max(e,meetings[i][1]);
        }
        if(e<days){
            count+=days-e;
        }
        return count;
    }
}