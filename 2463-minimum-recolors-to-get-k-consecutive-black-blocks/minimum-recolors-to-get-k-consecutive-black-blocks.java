class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0;
        int j=0;
        int min_b=k;
        int count=0;
        while(j<blocks.length()){
            if(blocks.charAt(j)=='W'){
                count++;
            }
            if(j-i+1==k){
                min_b=Math.min(min_b,count);
                if(blocks.charAt(i)=='W'){
                    count--;
                }
                i++;
            }
            j++;
        }
        return min_b;
    }
}