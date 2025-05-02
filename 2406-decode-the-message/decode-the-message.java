class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character,Character>mp=new HashMap<>();
        int tmp=97;
        for(char ch:key.toCharArray()){
            if(ch==' '){
                continue;
            }
            if(!mp.containsKey(ch)){
                mp.put(ch,(char)tmp);
                tmp++;
            }
        }

        StringBuilder res=new StringBuilder();
        for(char ch:message.toCharArray()){
            if(ch==' '){
                res.append(' ');
            }
            else{
                res.append(mp.get(ch));
            }
        }
        return res.toString();
    }
}