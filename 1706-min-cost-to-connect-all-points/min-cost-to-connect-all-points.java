class Solution {
    int[] parent;
    int rank[];
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
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }


    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int res=0;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        rank=new int[n];
        ArrayList<int[]>arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int wt=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                arr.add(new int[]{i,j,wt});
            }
        }

        Collections.sort(arr,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return Integer.compare(a[2],b[2]);
            }
        });

        for(int[] edge:arr){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            if(find(u)==find(v)){
                continue;
            }
            res+=wt;
            union(u,v);
        }

        return res;
    }
}