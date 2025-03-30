class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>list=new ArrayList<>();
        int n=s.length();
        int[] lastoccuridx=new int[26];
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            lastoccuridx[idx]=i;
        }
        int i=0;
        while(i<n){
            int end=lastoccuridx[s.charAt(i)-'a'];
            int j=i;
            while(j<end){
                end=Math.max(end,lastoccuridx[s.charAt(j)-'a']);
                j++;
            }
            list.add(j-i+1);
            i=j+1;
        }
        return list;
    }
}