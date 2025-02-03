class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list=new ArrayList<>();
        List<Integer>arrr=new ArrayList<>();
        generate(0,candidates,target,arrr);
        return list;
    }
    public void generate(int idx,int[] arr,int target,List<Integer>ar){
        if(idx==arr.length){
            if(target==0){
                list.add(new ArrayList<>(ar));
            }
            return;
        }
        if(arr[idx]<=target){
            ar.add(arr[idx]);
            generate(idx,arr,target-arr[idx],ar);
            ar.remove(ar.size()-1);
        }
        generate(idx+1,arr,target,ar);
    }
}