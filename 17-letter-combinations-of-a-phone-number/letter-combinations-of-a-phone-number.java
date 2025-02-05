class Solution {
    List<String>list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        String temp="";
        solve(digits,0,map,temp);
        return list;

    }
    public void solve(String digits,int idx,Map<Character,String>map,String temp){
        if(idx>=digits.length()){
            list.add(new String(temp));
            return;
        }

        char ch=digits.charAt(idx);
        String str=map.get(ch);
        for(int i=0;i<str.length();i++){
            temp+=str.charAt(i);
            solve(digits,idx+1,map,temp);
            temp=temp.substring(0,temp.length()-1);
        }
    }
}