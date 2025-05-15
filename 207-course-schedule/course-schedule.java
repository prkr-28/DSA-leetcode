class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>>graph=new HashMap<>();
        int[] indegree=new int[numCourses];
        for(int[] arr:prerequisites){
            int u=arr[0];
            int v=arr[1];

            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(v).add(u);
            indegree[u]++;
        }
        return bfs(graph,indegree);
    }
    public boolean bfs(Map<Integer,ArrayList<Integer>>graph,int[] indegree){
        Queue<Integer>q=new LinkedList<>();
        int count=0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            count++;
            for(int v:graph.getOrDefault(temp,new ArrayList<>())){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return count==indegree.length;
    }
}