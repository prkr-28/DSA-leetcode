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
        int x_parent=parent[x];
        int y_parent=parent[y];
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        int components=n;
        for(int[] arr:connections){
            int u=arr[0];
            int v=arr[1];
            if(find(u)==find(v)){
                continue;
            }
            else{
                union(u,v);
                components--;
            }
        }
        return components-1;
    }
}