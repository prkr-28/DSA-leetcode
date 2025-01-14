class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        String str=s;
        for(int i=1;i<s.length();i++){
            String temp=s.substring(i)+s.substring(0,i);
            str = (str.compareTo(temp) <= 0) ? str : temp;
        }
        return str;
    }
}