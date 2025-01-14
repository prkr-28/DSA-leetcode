class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int index=0;
        while(i<chars.length){
            char currch=chars[i];
            int count=0;
            while(i<n&&chars[i]==currch){
                count++;
                i++;
            }
            chars[index]=currch;
            index++;
            if(count>1){
                String s=String.valueOf(count);
                char[] temp=s.toCharArray();
                for(char c:temp){
                    chars[index]=c;
                    index++;
                }
            }
        }
        return index;
    }
}