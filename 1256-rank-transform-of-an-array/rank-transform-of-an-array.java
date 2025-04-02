class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        List<Integer>idxarr=new ArrayList<>();
        for(int i=0;i<n;i++){
            idxarr.add(i);
        }
        Collections.sort(idxarr,new Comparator<Integer>(){
            public int compare(Integer x,Integer y){
                return arr[x]-arr[y];
            }
        });

        int[] res=new int[n];
        int prev=Integer.MAX_VALUE;
        int rank=0;
        for(int i=0;i<idxarr.size();i++){
            if(prev!=arr[idxarr.get(i)]){
                prev=arr[idxarr.get(i)];
                rank++;
            }
            res[idxarr.get(i)]=rank;
        }
        return res;
    }
}