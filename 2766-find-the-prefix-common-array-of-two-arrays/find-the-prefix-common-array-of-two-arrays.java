class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans=new int[A.length];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            int count=0;
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            for(int temp:map.keySet()){
                if(map.get(temp)>=2){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}