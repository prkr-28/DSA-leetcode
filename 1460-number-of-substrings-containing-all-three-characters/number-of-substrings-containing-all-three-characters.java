class Solution {
    public int numberOfSubstrings(String s) {
        int[] map=new int[3];
        Arrays.fill(map,0);
        int n=s.length();
        int i=0;
        int j=0;
        int totalcount=0;
        while(j<n){
            char ch=s.charAt(j);
            map[ch-'a']++;
            while(map[0]>0&&map[1]>0&&map[2]>0){
                totalcount+=n-j;
                char c=s.charAt(i);
                map[c-'a']--;
                i++;
            }
            j++;
        }
        return totalcount;
    }
}