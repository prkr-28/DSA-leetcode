class Solution {
    Set<String> set = new HashSet<>();
    int n;
    Boolean[] t;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        t = new Boolean[n + 1];
        for (String word : wordDict) {
            set.add(word);
        }
        return solve(s, 0);
    }

    public boolean solve(String s, int idx) {
        if (idx == n) {
            return true;
        }

        if (t[idx] != null) {
            return t[idx];
        }

        for (int i = idx + 1; i <= n; i++) {
            String temp = s.substring(idx, i);
            if (set.contains(temp) && solve(s, i)) {
                return t[idx] = true;
            }
        }
        return t[idx] = false;
    }
}
