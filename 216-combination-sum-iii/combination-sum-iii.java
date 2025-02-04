class Solution {
     List<List<Integer>>list;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        list=new ArrayList<>();
        List<Integer>arrr=new ArrayList<>();
        generate(arr,n,0,k,arrr);
        return list;
    }
    public void generate(int[] arr,int n,int idx,int k,List<Integer>ar){
        if(n<0){
            return;
        }
        if(n==0){
            if(ar.size()==k){
                list.add(new ArrayList<>(ar));
            }
            return;
        }
        for(int i=idx;i<arr.length;i++){
            ar.add(arr[i]);
            generate(arr,n-arr[i],i+1,k,ar);
            ar.remove(ar.size()-1);
        }
    }
}