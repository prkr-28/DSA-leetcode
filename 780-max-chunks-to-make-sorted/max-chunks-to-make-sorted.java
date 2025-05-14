class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] prefixmax=new int[n];
        prefixmax[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixmax[i]=Math.max(prefixmax[i-1],arr[i]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(prefixmax[i]==i){
                count++;
            }
        }
        return count;
    }
}