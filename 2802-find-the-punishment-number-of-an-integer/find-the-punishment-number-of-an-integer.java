class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int sq=i*i;
            String s=String.valueOf(sq);
            if(check(0,0,s,i)==true){
                ans+=sq;
            }

        }
        return ans;
    }

    public boolean check(int i,int currsum,String s,int num){
        if(i==s.length()){
            return currsum==num;
        }
        if(currsum>num){
            return false;
        }
        boolean possible=false;
        for(int j=i;j<s.length();j++){
            String sub=s.substring(i,j+1);
            int value=Integer.parseInt(sub);
            possible=possible||check(j+1,currsum+value,s,num);
            if(possible==true){
                return true;
            }
        }
        return false;
    }
}