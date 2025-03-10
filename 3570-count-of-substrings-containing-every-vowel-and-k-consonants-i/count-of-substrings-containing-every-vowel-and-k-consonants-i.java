class Solution {
    public int countOfSubstrings(String word, int k) {
        int n=word.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(word.substring(i,j+1),k)==true){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isvowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public boolean check(String s,int k){
        //int vcount=0;
        int conso=0;
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isvowel(ch)){
                set.add(ch);
            }
            else{
                conso++;
            }
        }
        if(set.size()==5&&conso==k){
            return true;
        }
        return false;
    }
}