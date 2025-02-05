class Solution {
    List<List<String>>list;
    public List<List<String>> partition(String s) {
        list=new ArrayList<>();
        List<String>ar=new ArrayList<>();
        solve(s,0,ar);
        return list;
    }
    public void solve(String s,int idx,List<String>ar){
        if(idx==s.length()){
            list.add(new ArrayList<>(ar));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(ispalindrome(s,idx,i)){
                ar.add(s.substring(idx,i+1));
                solve(s,i+1,ar);
                ar.remove(ar.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s,int si,int ei){
        while(si<=ei){
            if(s.charAt(si++)!=s.charAt(ei--)){
                return false;
            }
        }
        return true;
    }
}