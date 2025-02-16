class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res=new int[2*n-1];
        Arrays.fill(res,-1);
        boolean[] used=new boolean[n+1];
        solve(res,n,0,used);
        return res;
    }
    public boolean solve(int[] res,int n,int idx,boolean[] used){
        if(idx==res.length){
            return true;
        }
        if(res[idx]!=-1){
            return solve(res,n,idx+1,used);
        }
        for(int i=n;i>=1;i--){
            if(used[i]==true){
                continue;
            }
            res[idx]=i;
            used[i]=true;
            if(i==1){
                if(solve(res,n,idx+1,used)==true){
                    return true;
                }
            }
            else{
                int j=idx+i;
                if(j<res.length&&res[j]==-1){
                    res[j]=i;
                    if(solve(res,n,idx+1,used)==true){
                        return true;
                    }
                    res[j]=-1;
                }
            }
            used[i]=false;
            res[idx]=-1;
        }
        return false;
    }
}