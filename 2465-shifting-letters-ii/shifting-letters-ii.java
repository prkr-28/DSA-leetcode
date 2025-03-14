class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diffarray=new int[s.length()+1];
        Arrays.fill(diffarray,0);
        for(int i=0;i<shifts.length;i++){
            int l=shifts[i][0];
            int r=shifts[i][1];
            int x=shifts[i][2]==0?-1:1;

            diffarray[l]+=x;
            diffarray[r+1]-=x;
        }
        for(int i=1;i<diffarray.length;i++){
            diffarray[i]=diffarray[i-1]+diffarray[i];
        }

        StringBuilder sb=new StringBuilder();
        int val=0;
        for(int i=0;i<s.length();i++){
            val=diffarray[i];
            int newchar=(((s.charAt(i)-'a')+val)%26);
            if(newchar<0){
                newchar+=26;
            }
            char ch=(char)(newchar+'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}