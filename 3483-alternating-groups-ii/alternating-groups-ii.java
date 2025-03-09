class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count=0;
        int length=1;
        int n=colors.length;
        for(int i=1;i<=n-1+k-1;i++){
            if(colors[i%n]!=colors[(i-1+n)%n]){
                length++;
            }
            else{
                length=1;
            }
            if(length>=k){
                count++;
            }
        }
        return count;
    }
}