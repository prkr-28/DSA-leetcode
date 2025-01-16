class Solution {
    public boolean halvesAreAlike(String s) {
        char[] arr=s.toCharArray();
        int c1=0;
        int c2=0;
        for(int i=0;i<arr.length/2;i++){
            if(arr[i]-'a'==0||arr[i]-'e'==0||arr[i]-'i'==0||
            arr[i]-'o'==0||arr[i]-'u'==0||arr[i]-'A'==0||arr[i]-'E'==0||
            arr[i]-'I'==0||arr[i]-'O'==0||arr[i]-'U'==0){
                c1++;
            }
        }
        for(int i=arr.length/2;i<arr.length;i++){
            if(arr[i]-'a'==0||arr[i]-'e'==0||arr[i]-'i'==0||
            arr[i]-'o'==0||arr[i]-'u'==0||arr[i]-'A'==0||arr[i]-'E'==0||
            arr[i]-'I'==0||arr[i]-'O'==0||arr[i]-'U'==0){
                c2++;
            }
        }
        if(c1==c2){
            return true;
        }else{
            return false;
        }
    }
}