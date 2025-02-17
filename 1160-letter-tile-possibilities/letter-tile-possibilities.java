class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String>set=new HashSet<>();
        boolean[] visited=new boolean[tiles.length()];
        solve(tiles,"",visited,set);
        return set.size()-1;
    }
    public void solve(String tiles,String res,boolean[] visited,Set<String>set){
        set.add(res);
        for(int i=0;i<tiles.length();i++){
            if(visited[i]==false){
                visited[i]=true;
                solve(tiles,res+tiles.charAt(i),visited,set);
                visited[i]=false;
            }
        }
    }
}