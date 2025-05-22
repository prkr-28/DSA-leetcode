class Pair{
    int wt;
    int v;
    public Pair(int w,int v){
        this.wt=w;
        this.v=v;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int res=0;
        Map<Integer,ArrayList<int[]>>graph=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int wt=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);

                graph.putIfAbsent(i,new ArrayList<>());
                graph.putIfAbsent(j,new ArrayList<>());

                graph.get(i).add(new int[]{j,wt});
                graph.get(j).add(new int[]{i,wt});
            }
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        boolean[] inMst=new boolean[n];
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int u=temp.v;
            int wt=temp.wt;

            if(inMst[u]==true){
                continue;
            }
            inMst[u]=true;
            res+=wt;
            for(int[] arr:graph.getOrDefault(u,new ArrayList<>())){
                int v=arr[0];
                int w=arr[1];

                if(!inMst[v]){
                    pq.add(new Pair(w,v));
                }
            }
        }
        return res;
    }
}