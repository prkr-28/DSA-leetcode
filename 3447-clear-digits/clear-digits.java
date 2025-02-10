class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}