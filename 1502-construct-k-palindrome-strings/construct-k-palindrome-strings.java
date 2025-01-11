class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()){
            return false;
        }
        if(k==s.length()){
            return true;
        }
        Map<Character,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(char c: map.keySet()){
            if(map.get(c)%2!=0){
                count++;
            }
        }
        if(count<=k){
            return true;
        }
        else{
            return false;
        }
    }
}