class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res=new int[queries.length];
        Map<Integer,Integer>map=new HashMap<>();// color->count
        Map<Integer,Integer>ballcolor=new HashMap<>();//ball[i]->color
        //Arrays.fill(ballcolor,-1);

        for(int i=0;i<queries.length;i++){
            int ball=queries[i][0];
            int color=queries[i][1];
            if(ballcolor.containsKey(ball)){
                int prevcolor=ballcolor.get(ball);
                map.put(prevcolor,map.getOrDefault(prevcolor,0)-1);
                if(map.get(prevcolor)==0){
                    map.remove(prevcolor);
                }
            }
            ballcolor.put(ball,color);
            map.put(color,map.getOrDefault(color,0)+1);
            res[i]=map.size();
        }
        return res;
    }
}