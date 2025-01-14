class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        if(pat.length()>txt.length()){
            return new ArrayList<>();
        }
        List<Integer>ans=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        int[] patternfreq=new int[26];
        int[] textfreq=new int[26];
        int count=0;
        int left=0;
        for(int i=0;i<m;i++){
            patternfreq[pat.charAt(i)-'a']++;
            textfreq[txt.charAt(i)-'a']++;
        }
        if(Arrays.equals(patternfreq,textfreq)){
            ans.add(left);
        }
        for(int i=m;i<n;i++){
            textfreq[txt.charAt(i)-'a']++;
            textfreq[txt.charAt(left)-'a']--;
            left++;
            if(Arrays.equals(patternfreq,textfreq)){
                ans.add(left);
            }
        }
        return ans;
    }
}