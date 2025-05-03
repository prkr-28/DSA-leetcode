class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int swaps=findSwaps(tops,bottoms,i);
            if(swaps!=-1){
                res=Math.min(res,swaps);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int findSwaps(int[] tops,int[] bottoms,int val){
        int topswap=0;
        int bottomswap=0;
        //check for top swap..
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=val&&bottoms[i]!=val){
                return -1;
            }
            else if(tops[i]!=val){
                topswap++;
            }
        }

        //check for bottom swaps...
        for(int i=0;i<bottoms.length;i++){
            if(tops[i]!=val&&bottoms[i]!=val){
                return -1;
            }
            else if(bottoms[i]!=val){
                bottomswap++;
            }
        }

        return Math.min(topswap,bottomswap);
    }
}