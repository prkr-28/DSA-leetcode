class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String>set=new HashSet<>(dictionary);
        String[] words=sentence.split(" ");

        StringBuilder res=new StringBuilder();

        for(String s:words){
            res.append(findword(s,set)).append(" ");
        }
        //res.deleteCharAt(res.length()-1);
        return res.toString().trim();
    }

    public String findword(String s,Set<String>set){
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if(set.contains(temp)){
                return temp;
            }
        }
        return s;
    }
}