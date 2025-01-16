class Solution {
    public boolean halvesAreAlike(String s) {
        char[] arr=s.toCharArray();
        int c1=0;
        int c2=0;
        for(int i=0;i<arr.length/2;i++){
            if(isvovel(arr[i])){
                c1++;
            }
        }
        for(int i=arr.length/2;i<arr.length;i++){
            if(isvovel(arr[i])){
                c2++;
            }
        }
        if(c1==c2){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isvovel(char ch){
        if(ch-'a'==0||ch-'e'==0||ch-'i'==0||
            ch-'o'==0||ch-'u'==0||ch-'A'==0||ch-'E'==0||
            ch-'I'==0||ch-'O'==0||ch-'U'==0){
            return true;
        }
        return false;
    }
}