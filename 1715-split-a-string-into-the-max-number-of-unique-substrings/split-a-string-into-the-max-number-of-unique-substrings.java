class Solution {
    int n;
    int maxcount;
    public int maxUniqueSplit(String s) {
        n=s.length();
        maxcount=0;
        int count=0;
        Set<String>set=new HashSet<>();
        solve(s,count,0,set);
        return maxcount;
    }
    public void solve(String s,int count,int idx,Set<String>set){
        if((count+(n-idx))<maxcount){
            return;
        }
        if(idx==n){
            maxcount=Math.max(count,maxcount);
            return;
        }
        for(int i=idx;i<n;i++){
            String subs=s.substring(idx,i+1);
            if(!set.contains(subs)){
                set.add(subs);
                solve(s,count+1,i+1,set);
                set.remove(subs);
            }
        }
    }
}