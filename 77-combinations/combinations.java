class Solution {
    List<List<Integer>>list=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>ar=new ArrayList<>();
        solve(n,k,1,ar);
        return list;
    }
    public void solve(int n,int k,int idx,List<Integer>ar){
        if(ar.size()==k){
            list.add(new ArrayList<>(ar));
            return;
        }
        if(idx>n){
            return;
        }
        for(int i=idx;i<=n;i++){
            ar.add(i);
            solve(n,k,i+1,ar);
            ar.remove(ar.size()-1);
        }
    }
}