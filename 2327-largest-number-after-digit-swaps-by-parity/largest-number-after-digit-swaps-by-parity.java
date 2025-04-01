class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer>evenpq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>oddpq=new PriorityQueue<>(Collections.reverseOrder());

        int n=num;
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int rem=n%10;
            sb.append(rem);
            if(rem%2==0){
                evenpq.add(rem);
            }
            else{
                oddpq.add(rem);
            }
            n=n/10;
        }
        sb.reverse();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if((sb.charAt(i) - '0') % 2 == 0){
                res.append(evenpq.poll());
            }
            else{
                res.append(oddpq.poll());
            }
        }
        return Integer.parseInt(res.toString());
    }
}