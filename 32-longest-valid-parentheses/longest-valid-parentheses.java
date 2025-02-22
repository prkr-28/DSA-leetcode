class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int left=0;
        int right=0;
        int maxlength=0;
        //checking left to right....
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxlength=Math.max(maxlength,left*2);
            }
            else if(left<right){
                left=0;
                right=0;
            }
        }
        //checking right to left...
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxlength=Math.max(maxlength,left*2);
            }
            else if(left>right){
                left=0;
                right=0;
            }
        }
        return maxlength;
    }
}