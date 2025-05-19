class Pair implements Comparable<Pair>{
    int cost;
    int vertex;
    
    public Pair(int c,int v){
        this.cost=c;
        this.vertex=v;
    }
    
    public int compareTo(Pair that){
        if(this.cost==that.cost){
            return this.vertex-that.vertex;
        }
        return this.cost-that.cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        Map<Integer,ArrayList<int[]>>graph=new HashMap<>();
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];
            
            graph.putIfAbsent(u,new ArrayList<>());
            graph.get(u).add(new int[]{v,w});
        }
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        
        pq.add(new Pair(0,k));
        res[k]=0;
        
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int u=temp.vertex;
            int c=temp.cost;
            
            for(int[] arr:graph.getOrDefault(u,new ArrayList<>())){
                int v=arr[0];
                int n_c=arr[1];
                if(c+n_c<res[v]){
                    res[v]=c+n_c;
                    pq.add(new Pair(res[v],v));
                }
            }
        }
        int mintym=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(res[i]==Integer.MAX_VALUE){
                return -1;
            }
            mintym=Math.max(mintym,res[i]);
        }
        return mintym;
    }
}