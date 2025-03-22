class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        int res=0;
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(v);
            map.putIfAbsent(v,new ArrayList<>());
            map.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==true){
                continue;
            }
            int[] info=new int[2];
            Arrays.fill(info,0);
            bfs(i,map,visited,info);

            int edge=info[1];
            if((info[0]*(info[0]-1))==edge){
                res++;
            }
        }
        return res;
    }
    public void bfs(int i,HashMap<Integer,ArrayList<Integer>>map,boolean[] visited,int[] info)  {
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        visited[i]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            info[0]++;
            info[1]+=map.getOrDefault(temp,new ArrayList<>()).size();
            for(int nbr:map.getOrDefault(temp,new ArrayList<>())){
                if(!visited[nbr]){
                    q.add(nbr);
                    visited[nbr]=true;
                }
            }
        }
    }
}