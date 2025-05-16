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
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
        }

        for(String s:equations){
            if(s.contains("==")){
                int x=s.charAt(0)-'a';
                int y=s.charAt(3)-'a';
                union(x,y);
            }
        }
        for(String s:equations){
            if(s.contains("!=")){
                int x=find(s.charAt(0)-'a');
                int y=find(s.charAt(3)-'a');
                if(x==y){
                    return false;
                }
            }
        }
        return true;
    }
}