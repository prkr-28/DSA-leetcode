class Solution {
    public String removeStars(String s) {
        char[] temp=new char[s.length()];
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                j--;
            }
            else{
                temp[j]=s.charAt(i);
                j++;
            }
        }
        String result="";
        for(int i=0;i<j;i++){
            // if(Character.isLetter(temp[i])){
            //     result+=temp[i];
            // }
            result+=temp[i];
        }
        return result;
    }
}