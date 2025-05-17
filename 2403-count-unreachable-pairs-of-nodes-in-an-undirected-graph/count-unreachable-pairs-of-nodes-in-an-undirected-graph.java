class Solution {
    long count;
    public long countPairs(int n, int[][] edges) {
        count=0;
        Map<Integer,ArrayList<Integer>>graph=new HashMap<>();
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        long temp=n;
        long res=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(graph,i,visited);
                res+=count*(temp-count);
                temp=temp-count;
                count=0;
            }
        }
        return res;
    }

    public void bfs(Map<Integer,ArrayList<Integer>>graph,int u,boolean[] visited){
        Queue<Integer>q=new LinkedList<>();
        q.add(u);
        visited[u]=true;
        count++;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int v:graph.getOrDefault(temp,new ArrayList<>())){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                    count++;
                }
            }
        }
    }
}