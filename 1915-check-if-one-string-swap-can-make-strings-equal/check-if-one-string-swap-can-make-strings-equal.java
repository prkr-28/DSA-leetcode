class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        int i_=-1;
        int j_=-1;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(i_==-1){
                    i_=i;
                }
                else if(j_==-1){
                    j_=i;
                }
            }
        }
        if(count==0){
            return true;
        }
        else if(count==2&&s1.charAt(i_)==s2.charAt(j_)&&s1.charAt(j_)==s2.charAt(i_)){
            return true;
        }
        return false;
    }
}