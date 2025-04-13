class Pair implements Comparable<Pair>{
    int val;
    int freq;

    public Pair(int v,int f){
        this.val=v;
        this.freq=f;
    }
    public int compareTo(Pair that){
        return this.freq-that.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        List<Integer>res=new ArrayList<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i:map.keySet()){
            pq.add(new Pair(i,map.get(i)));
            if(pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            res.add(pq.poll().val);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}