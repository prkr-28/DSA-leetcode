class Pair{
    int count;
    char ch;

    public Pair(int c,char ch){
        this.count=c;
        this.ch=ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.count, p1.count));

        if(a>0){
            pq.add(new Pair(a,'a'));
        }
        if(b>0){
            pq.add(new Pair(b,'b'));
        }
        if(c>0){
            pq.add(new Pair(c,'c'));
        }
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int count=temp.count;
            char ch=temp.ch;

            if(res.length()>=2&&res.charAt(res.length()-1)==ch
            &&res.charAt(res.length()-2)==ch){
                if(pq.isEmpty()){
                    break;
                }
                Pair tmp=pq.poll();
                int nextcount=tmp.count;
                char nextchar=tmp.ch;

                res.append(nextchar);
                nextcount--;
                if(nextcount>0){
                    pq.add(new Pair(nextcount,nextchar));
                }
            }
            else{
                res.append(ch);
                count--;
            }
            if(count>0){
                pq.add(new Pair(count,ch));
            }
        }

        return res.toString();
    }
}