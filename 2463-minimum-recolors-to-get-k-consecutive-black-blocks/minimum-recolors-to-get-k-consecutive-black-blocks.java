class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0;
        int j=k-1;
        int min_b=k;
        while(j<blocks.length()){
            int count=0;
            for(int k_=i;k_<=j;k_++){
                if(blocks.charAt(k_)=='W'){
                    count++;
                }
            }
            if(count<min_b){
                min_b=count;
            }
            i++;
            j++;
        }
        return min_b;
    }
}