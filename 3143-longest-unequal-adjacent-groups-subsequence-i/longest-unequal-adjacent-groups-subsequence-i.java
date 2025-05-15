class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<Integer>list=new ArrayList<>();
        list.add(0);
        for(int i=1;i<n;i++){
            if(groups[i]!=groups[i-1]){
                list.add(i);
            }
        }
        List<String>ans=new ArrayList<>();
        for(int i:list){
            ans.add(words[i]);
        }
        return ans;
    }
}