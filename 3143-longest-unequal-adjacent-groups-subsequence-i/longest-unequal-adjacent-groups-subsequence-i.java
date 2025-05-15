class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<String>ans=new ArrayList<>();
        int prev=groups[0];
        ans.add(words[0]);
        for(int i=1;i<n;i++){
            if(groups[i]!=prev){
                ans.add(words[i]);
                prev=groups[i];
            }
        }
        return ans;
    }
}