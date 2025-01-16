class Solution {
    public boolean detectCapitalUse(String word) {
        if(allcapital(word)||allsmall(word)||
        allsmall(word.substring(1))){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean allcapital(String s){
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!(ch>='A'&&ch<='Z')){
                return false;
            }
        }
        return true;
    }
    public static boolean allsmall(String s){
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!(ch>='a'&&ch<='z')){
                return false;
            }
        }
        return true;
    }
}