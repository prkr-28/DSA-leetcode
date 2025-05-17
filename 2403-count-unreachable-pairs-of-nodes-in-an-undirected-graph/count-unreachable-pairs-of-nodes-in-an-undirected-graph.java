class Solution {
    int[] parent;
    int[] rank;
    public int find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i]=find(parent[i]);
    }
    public void union(int x,int y){
        int x_parent=find(x);
        int y_parent=find(y);
        if(x_parent==y_parent){
            return;
        }
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }
        else if(rank[x_parent]<rank[y_parent]){
            parent[x_parent]=y_parent;
        }
        else{
            parent[y_parent]=x_parent;
            rank[x_parent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];

            if(find(u)==find(v)){
                continue;
            }
            else{
                union(u,v);
            }
        }

        Map<Long,Long>map=new HashMap<>();
        for(int i=0;i<n;i++){
            long parent=find(i);
            map.put(parent,map.getOrDefault(parent,0L)+1);
        }

        long res=0;
        long temp=n;
        for(long i:map.keySet()){
            res+=map.get(i)*(temp-map.get(i));
            temp=temp-map.get(i);
        }
        return res;
    }
}