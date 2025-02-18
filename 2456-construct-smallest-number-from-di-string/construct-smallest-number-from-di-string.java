class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        Stack<Integer>s=new Stack<>();
        int count=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=n;i++){
            s.push(count);
            count++;
            if(i==n||pattern.charAt(i)=='I'){
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
            }
        }
        return sb.toString();
    }
}