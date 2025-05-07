class Pair{
    char ch;
    int idx;
    public Pair(char c,int i){
        this.ch=c;
        this.idx=i;
    }
}
class Solution {
    public String clearStars(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.ch==b.ch){
                return b.idx-a.idx;
            }
            else{
                return Character.compare(a.ch,b.ch);
            }
        });
        int i=0;
        while(i<n){
            if(arr[i]=='*'){
                Pair temp=pq.poll();
                int idx=temp.idx;
                arr[idx]='.';
            }
            else{
                pq.add(new Pair(arr[i],i));
            }
            i++;
        }
        StringBuilder res=new StringBuilder();
        for(int j=0;j<n;j++){
            if(arr[j]!='.'&&arr[j]!='*'){
                res.append(arr[j]);
            }
        }
        return res.toString();
    }
}