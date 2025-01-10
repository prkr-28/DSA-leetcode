class Solution {
    public String removeOccurrences(String s, String part) {
        int index;
        while((index=s.indexOf(part))!=-1){
            s=s.substring(0,index)+s.substring(index+part.length());
        }
        return s;
    }
}