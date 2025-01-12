class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        //left and right count method.....
        int leftcount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || locked.charAt(i)=='0'){
                leftcount++;
            }
            else{
                leftcount--;
            }
            if(leftcount<0){
                return false;
            }
        }
        int rightcount=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')' || locked.charAt(i)=='0'){
                rightcount++;
            }
            else{
                rightcount--;
            }
            if(rightcount<0){
                return false;
            }
        }
        return true;
    }
}