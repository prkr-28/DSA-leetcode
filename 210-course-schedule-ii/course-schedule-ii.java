class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>>graph=new HashMap<>();
        int[] indegree=new int[numCourses];
        for(int[] arr:prerequisites){
            int u=arr[0];
            int v=arr[1];

            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(v).add(u);
            indegree[u]++;
        }
        ArrayList<Integer>res=new ArrayList<>();
        toposort(graph,res,indegree);
        if(res.size()!=numCourses){
            return new int[0];
        }
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }

    public void toposort(Map<Integer,ArrayList<Integer>>graph,ArrayList<Integer>res,int[] indegree){
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            res.add(temp);
            for(int v:graph.getOrDefault(temp,new ArrayList<>())){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
    }
}