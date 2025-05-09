class Pair{
    char ch;
    int freq;
    public Pair(char c,int f){
        this.ch=c;
        this.freq=f;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>Math.ceil((double)s.length()/2)){
                return "";
            }
        }
        StringBuilder res=new StringBuilder();
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(char c:map.keySet()){
            pq.add(new Pair(c,map.get(c)));
        }
        while(pq.size()>=2){
            Pair p1=pq.poll();
            Pair p2=pq.poll();
            res.append(p1.ch);
            p1.freq--;
            res.append(p2.ch);
            p2.freq--;

            if(p1.freq>0){
                pq.add(p1);
            }
            if(p2.freq>0){
                pq.add(p2);
            }
        }
        if(pq.size()>0){
            res.append(pq.poll().ch);
        }
        return res.toString();
    }
}