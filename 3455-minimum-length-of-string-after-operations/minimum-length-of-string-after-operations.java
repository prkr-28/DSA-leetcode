class Solution {
    public int minimumLength(String s) {
        if(s.length()<3){
            return s.length();
        }
        int length=0;
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char c:map.keySet()){
            if(map.get(c)>3){
                if(map.get(c)%2==0){
                    length+=2;
                }
                else{
                    length+=1;
                }
            }
            else if(map.get(c)==3){
                length+=1;
            }
            else{
                length+=map.get(c);
            }
        }
        return length;
    }
}