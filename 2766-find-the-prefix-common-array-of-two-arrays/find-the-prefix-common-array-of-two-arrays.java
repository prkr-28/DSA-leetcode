class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        List<Integer>arr=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int count=0;
            Map<Integer,Integer>map=new HashMap<>();
            for(int j=0;j<=i;j++){
                map.put(A[j],map.getOrDefault(A[j],0)+1);
                map.put(B[j],map.getOrDefault(B[j],0)+1);
            }
            for(int temp:map.keySet()){
                if(map.get(temp)>=2){
                    count++;
                }
            }
            arr.add(count);
        }
        int[] ans=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}