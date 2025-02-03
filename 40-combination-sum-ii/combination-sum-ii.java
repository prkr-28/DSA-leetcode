class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        list=new ArrayList<>();
        List<Integer>arrr=new ArrayList<>();
        generate(candidates,target,0,arrr);
        return list;
    }
    public void generate(int[] arr,int target,int idx,List<Integer>ar){
        if(target<0){
            return;
        }
        if(target==0){
            list.add(new ArrayList<>(ar));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx&&arr[i]==arr[i-1]){
                continue;
            }
            ar.add(arr[i]);
            generate(arr,target-arr[i],i+1,ar);
            ar.remove(ar.size()-1);
        }
    }
}