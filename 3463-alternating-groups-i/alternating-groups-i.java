class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(colors[i%n]!=colors[(i-1+n)%n]&&colors[i%n]!=colors[(i+1)%n]){
                count++;
            }
        }
        return count;
    }
}