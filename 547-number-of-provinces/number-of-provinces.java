class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        Map<Integer,ArrayList<Integer>>graph=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j&&isConnected[i][j]==1){
                    graph.putIfAbsent(i,new ArrayList<>());
                    graph.putIfAbsent(j,new ArrayList<>());

                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited=new boolean[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                res++;
                dfs(graph,i,visited);
            }
        }
        return res;
    }
    public void dfs(Map<Integer,ArrayList<Integer>>graph,int u,boolean[] visited){
        visited[u]=true;
        for(int v:graph.getOrDefault(u,new ArrayList<>())){
            if(!visited[v]){
                dfs(graph,v,visited);
            }
        }
    }
}