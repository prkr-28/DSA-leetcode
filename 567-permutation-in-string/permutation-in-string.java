class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int i=0;
        int j=n-1;
        while(j<m){
            Map<Character,Integer>map=new HashMap<>();
            for(int k=i;k<=j;k++){
                map.put(s2.charAt(k),map.getOrDefault(s2.charAt(k),0)+1);
            }
            for(int l=0;l<n;l++){
                if(map.containsKey(s1.charAt(l))){
                    if (map.get(s1.charAt(l)) == 1) {
                        map.remove(s1.charAt(l));
                    } else {
                        map.put(s1.charAt(l), map.get(s1.charAt(l)) - 1);
                    }
                }
            }
            if(map.size()==0){
                return true;
            }
            else{
                i++;
                j++;
            }
        }
        return false;
    }
}