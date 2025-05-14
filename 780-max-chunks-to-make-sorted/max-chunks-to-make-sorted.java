class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] prefixmax=new int[n];
        int[] suffixmin=new int[n];
        prefixmax[0]=arr[0];
        suffixmin[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            prefixmax[i]=Math.max(prefixmax[i-1],arr[i]);
        }

        for(int i=n-2;i>=0;i--){
            suffixmin[i]=Math.min(suffixmin[i+1],arr[i]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            int pehlemax=i>0?prefixmax[i-1]:-1;
            int badkamin=suffixmin[i];
            if(badkamin>pehlemax){
                count++;
            }
        }
        return count;
    }
}